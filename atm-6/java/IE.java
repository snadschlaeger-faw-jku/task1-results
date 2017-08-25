//package net.nadschlaeger;

//import net.nadschlaeger;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

class IE {
	public static void main(String[] args) {
		String line;
		List<Object> facts = new ArrayList<Object>();

		try {
			InputStream fis = new FileInputStream(
					"C:\\Users\\snadschlaeger\\Downloads\\diss-eval\\task1\\atm-6\\java\\facts");
			InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
			BufferedReader br = new BufferedReader(isr);

			while ((line = br.readLine()) != null) {

				List<Object> properties = new ArrayList<Object>();
				for (String prop : line.split(";")[1].split(",")) {
					properties.add(new Property(prop.split(":")[0], "java.lang.String", prop.split(":")[1]));
				}

				facts.add(new Fact(line.split(";")[0], properties));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// ----

		List<Object> rules = new ArrayList<Object>();

		List<Object> conditionsRule1 = new ArrayList<Object>();
		List<Object> properties1 = new ArrayList<Object>();
		properties1.add(new Property("cardNumber", "java.lang.String", "123"));
		Fact factCond1 = new Fact("CreditCard", properties1);
		conditionsRule1.add(new Clause(ClauseOperators.exists, factCond1));

		List<Object> consequencesRule1 = new ArrayList<Object>();
		List<Object> properties2 = new ArrayList<Object>();
		properties2.add(new Property("cardNumber", "java.lang.String", "123"));
		properties2.add(new Property("pinNumber", "java.lang.String", null));
		Fact factCons1 = new Fact("Pin", properties2);
		consequencesRule1.add(new Consequence(ClauseOperators.assertFact, factCons1));

		rules.add(new Rule(RuleOperator.AND, conditionsRule1, consequencesRule1));

		// ----

		List<Object> conditionsRule2 = new ArrayList<Object>();
		List<Object> properties3 = new ArrayList<Object>();
		conditionsRule2.add(new Clause(ClauseOperators.exists, null));

		List<Object> consequencesRule2 = new ArrayList<Object>();
		List<Object> properties4 = new ArrayList<Object>();
		properties4.add(new Property("amount", "java.lang.String", null));
		Fact factCons2 = new Fact("WithDrawMoney", properties4);
		consequencesRule2.add(new Consequence(ClauseOperators.assertFact, factCons2));

		rules.add(new Rule(RuleOperator.AND, conditionsRule2, consequencesRule2));

		BruteForceIE ie = new BruteForceIE(rules, facts);

		ie.checkRules();
	}
}