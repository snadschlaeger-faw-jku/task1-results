package net.nadschlaeger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.nadschlaeger.model.Fact;
import net.nadschlaeger.model.Property;

public class ConnectionManager {

	private static final String DB_URL = "jdbc:h2:~/.stefan/diss";

	private static Connection connection;

	private static Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName("org.h2.Driver");
				connection = DriverManager.getConnection(DB_URL);
				connection.setAutoCommit(false);
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

	public static List<Fact> getAllFacts() {
		List<Fact> facts = new ArrayList<Fact>();
		Statement stmt = null;
		try {
			stmt = getConnection().createStatement();
			ResultSet factRS = stmt.executeQuery("SELECT * FROM facts");
			// print out query result
			for (; factRS.next();) {
				Fact fact = new Fact();
				String factName = factRS.getString("name");
				fact.setName(factName);
				facts.add(fact);
			}

			for (Fact fact : facts) {
				ResultSet propRS = stmt.executeQuery("SELECT * FROM properties WHERE fact = '" + fact.getName() + "'");
				for (; propRS.next();) {
					Property p = new Property();
					p.setName(propRS.getString("name"));
					p.setType(propRS.getString("type"));
					p.setValue(propRS.getString("value"));
					p.setMandatory(propRS.getBoolean("mandatory"));
					p.setRequiresUserInput(propRS.getBoolean("userinput"));
					fact.getProperties().add(p);
				}
			}
			return facts;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException ex) {
					System.out.println("Could not close query");
				}
			}
		}
		return facts;
	}

	public static void initDB() throws SQLException {
		Statement stmt = getConnection().createStatement();

		// drop table
		stmt.executeUpdate("DROP TABLE IF EXISTS properties");
		stmt.executeUpdate("DROP TABLE IF EXISTS facts");

		// create table
		stmt.executeUpdate(
				"Create table properties (id int primary key, name varchar(255), type varchar(255), value varchar(255), mandatory boolean, userinput boolean, fact varchar(255))");
		stmt.executeUpdate("Create table facts (name varchar(255) primary key)");

		// insert 2 rows
		stmt.executeUpdate("insert into facts values ('VISA')");
		stmt.executeUpdate("insert into facts values ('MASTERCARD')");

		stmt.executeUpdate(
				"insert into properties values (1, 'cardNumber', 'java.lang.String', '1234567', true, false, 'VISA')");
		stmt.executeUpdate(
				"insert into properties values (2, 'pinCode', 'java.lang.String', '5555', true, true, 'VISA')");
		stmt.executeUpdate(
				"insert into properties values (3, 'cardNumber', 'java.lang.String', '7654321', true, false, 'MASTERCARD')");
		stmt.executeUpdate(
				"insert into properties values (4, 'pinCode', 'java.lang.String', '6666', true, true, 'MASTERCARD')");

	}
}