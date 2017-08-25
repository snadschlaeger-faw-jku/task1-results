package main.java;

import main.java.model.CreditCard;
import main.java.model.Pin;
import main.java.model.Rule;

public class Test {

	
	private static BruteForceIE b = new BruteForceIE();

	private static void initData() {
		Storage.data.add(new CreditCard("123"));
		Storage.data.add(new Pin(new CreditCard("1234"),"1234"));
	}

	private static void initRules() {
//		Rule creditCard1=new Rule(ClauseOperators.exists, new CreditCard("1234"));
//		Rule pin1=new Rule(ClauseOperators.exists, new Pin(new CreditCard("1234"),"1234"));
//		creditCard1.operator=RuleOperator.AND;
//		
//		creditCard1.conditions.add(creditCard1);
//		creditCard1.conditions.add(pin1);
//		
//		Rule balance=new Rule(ClauseOperators.assertFact, new Account(new CreditCard("1234")));
//		creditCard1.action=balance;
//		Storage.rules.add(creditCard1);
		
		
//		Rule creditCard=new Rule(ClauseOperators.exists, new CreditCard("123"));
//		Rule pin=new Rule(ClauseOperators.assertFact, new Pin(new CreditCard("123")));
//		creditCard.action=pin;
//		Storage.rules.add(creditCard);
		
		
		Rule creditCard_1=new Rule(ClauseOperators.exists, new CreditCard("123"));
		Rule creditCard_2=new Rule(ClauseOperators.exists, new CreditCard("999"));
		creditCard_1.operator=RuleOperator.OR;
		creditCard_1.conditions.add(creditCard_1);
		creditCard_1.conditions.add(creditCard_2);
		Rule print=new Rule(ClauseOperators.assertFact, new CreditCard("1"));
		creditCard_1.action=print;
		Storage.rules.add(creditCard_1);
	}

	public static void main(String[] args) {
		initData();
		initRules();
		System.out.println(Storage.data);
		System.out.println("-------");
		b.checkRules();
		System.out.println(Storage.runtimeData);
	}

}
