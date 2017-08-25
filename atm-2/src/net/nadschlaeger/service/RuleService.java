package net.nadschlaeger.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.nadschlaeger.ClauseOperators;
import net.nadschlaeger.RuleOperator;
import net.nadschlaeger.model.Action;
import net.nadschlaeger.model.Condition;
import net.nadschlaeger.model.Fact;
import net.nadschlaeger.model.Property;
import net.nadschlaeger.model.Rule;
import net.nadschlaeger.model.Value;

public class RuleService {

	private final FactStorage factStorage;

	public RuleService(FactStorage factStorage) {
		super();
		this.factStorage = factStorage;

	}

	public List<Rule> getAllRules() {
		final Property card = new Property("cardNumber", false, 123, true);
		final Fact f = new Fact("CreditCard", Arrays.asList(card));
		factStorage.assertFact(new Fact("PIN", Arrays.asList(card,
				new Property("net.nadschlaeger.model.PinNumber", false, new Value("1234"), false))));


		final Fact a = new Fact("PIN", Arrays.asList(card,
				new Property("net.nadschlaeger.model.Value", true, null, false)));
		final Rule creditCardExists = new Rule(RuleOperator.AND,
				Arrays.asList(new Condition(ClauseOperators.exists, f)),
				Arrays.asList(new Action(ClauseOperators.assertFact, a)));
		creditCardExists.setOperator(RuleOperator.AND);
		factStorage.assertFact(f);
		// TODO Auto-generated method stub
		final List<Rule> result = new ArrayList<>();
		result.add(creditCardExists);

		final Fact w = new Fact("WithDrawMoney", Arrays.asList(new Property("net.nadschlaeger.model.Value", true, null, true)));

		final Rule r = new Rule(RuleOperator.AND,
				Arrays.asList(
						new Condition(ClauseOperators.exists, f),//TODO get from runtimeStore
						new Condition(ClauseOperators.take, a),
						new Condition(ClauseOperators.exists, null)),
				Arrays.asList(new Action(ClauseOperators.assertFact, w),new Action(ClauseOperators.print, new Fact("Finished", null))));
		result.add(r);
		return result;
	}

}
