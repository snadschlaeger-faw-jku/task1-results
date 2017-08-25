package net.nadschlaeger;

import java.sql.SQLException;

public class Application {

	public static void main(String[] args) {
		try {
			ConnectionManager.initDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BruteForceIE ie = new BruteForceIE();
		ie.checkRules();
	}

}
