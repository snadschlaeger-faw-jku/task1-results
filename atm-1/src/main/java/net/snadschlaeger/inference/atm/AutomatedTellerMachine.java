package net.snadschlaeger.inference.atm;

import net.snadschlaeger.inference.BruteForceIE;
import net.snadschlaeger.inference.ClauseOperator;
import net.snadschlaeger.inference.RuleOperator;
import net.snadschlaeger.inference.model.Action;
import net.snadschlaeger.inference.model.Fact;
import net.snadschlaeger.inference.model.Property;
import net.snadschlaeger.inference.model.Rule;

public class AutomatedTellerMachine extends BruteForceIE {

	public AutomatedTellerMachine() {
		Fact creditCard = Fact.create("CreditCard")
				.addProperty(Property.create("cardNumber", String.class, "123").setRequiresUserInput(false));
		getFacts().add(creditCard);
		Fact pin = Fact.create("Pin").addProperty(Property.create("cardNumber", String.class, "123"))
				.addProperty(Property.create("pinNumber", String.class, null));
		getFacts().add(pin);
		Fact account = Fact.create("Account").addProperty(Property.create("balance", Integer.class, "500"))
				.addProperty(Property.create("cardNumber", String.class, "123"));
		getFacts().add(account);

		getAllRules().add(Rule.create().setOperator(RuleOperator.AND)
				.addCondition(Action.create(ClauseOperator.exists).setParameter(creditCard))
				.addAction(Action.create(ClauseOperator.assertFact).setParameter(pin)));

		Fact withDrawMoney = Fact.create("WithDrawMoney").addProperty(Property.create("amount", Integer.class, null));
		getAllRules().add(Rule.create().setOperator(RuleOperator.AND)
				.addCondition(Action.create(ClauseOperator.exists).setParameter(pin))
				.addAction(Action.create(ClauseOperator.assertFact).setParameter(withDrawMoney)));

		checkRules();
	}

}
