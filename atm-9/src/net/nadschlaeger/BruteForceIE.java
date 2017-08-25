package net.nadschlaeger;

import java.util.ArrayList;
import java.util.List;

import net.nadschlaeger.model.Condition;
import net.nadschlaeger.model.Fact;
import net.nadschlaeger.model.Parameter;
import net.nadschlaeger.model.Property;
import net.nadschlaeger.model.Rule;

/**
 * Created by snadschlaeger on 28.12.2016.
 */
public class BruteForceIE extends AbstractIE {

	List<Fact> runtimeFacts = new ArrayList<Fact>();

	@Override
	protected void assertFact(Object fact) {
		runtimeFacts.add((Fact) fact);
	}

	@Override
	protected void clearRuntimeFactStorage() {
		runtimeFacts.clear();
	}

	@Override
	protected List<Object> getAllFacts() {
		List<Fact> facts = ConnectionManager.getAllFacts();
		return new ArrayList<Object>(facts);
	}

	@Override
	protected List<Object> getAllFactsInRuntimeStorage() {
		return new ArrayList<Object>(runtimeFacts);
	}

	@Override
	protected List<Object> getAllRules() {
		List<Rule> rules = new ArrayList<Rule>();

		// definition of the rules
		// time runs out...
		Rule rule = new Rule();
		rule.setRuleOperator(RuleOperator.AND);
		Condition c = new Condition(ClauseOperators.exists.name());
		c.setParameter(new Parameter("cardNumber", "1234567"));
		rule.getConditions().add(c);
		Condition cons = new Condition(ClauseOperators.assertFact.name());
		cons.setParameter(new Parameter("pinCode", "5555"));
		rule.getConsequences().add(cons);
		rules.add(rule);
		return new ArrayList<Object>(rules);
	}

	@Override
	protected String getConditionExpression(Object condition) {
		if (condition instanceof Condition) {
			return ((Condition) condition).getExpression();
		}
		return null;
	}

	@Override
	protected Object getConditionParameter(Object condition) {
		if (condition instanceof Condition) {
			return ((Condition) condition).getParameter();
		}
		return null;
	}

	@Override
	protected String getConsequenceExpression(Object consequence) {
		if (consequence instanceof Condition) {
			return ((Condition) consequence).getExpression();
		}
		return null;
	}

	@Override
	protected Object getConsequenceParameter(Object consequence) {
		if (consequence instanceof Condition) {
			return ((Condition) consequence).getParameter();
		}
		return null;
	}

	@Override
	protected String getFactName(Object fact) {
		if (fact instanceof Fact) {
			return ((Fact) fact).getName();
		}
		return null;
	}

	@Override
	protected List<Object> getFactProperties(Object fact) {
		if (fact instanceof Fact) {
			List<Property> properties = ((Fact) fact).getProperties();
			return new ArrayList<Object>(properties);
		}
		return null;
	}

	@Override
	protected String getFactPropertyName(Object property) {
		if (property instanceof Property) {
			return ((Property) property).getName();
		}
		return null;
	}

	@Override
	protected Object getFactPropertyOnPosition(Object fact, int position) {
		if (fact instanceof Fact) {
			List<Property> properties = ((Fact) fact).getProperties();
			return properties.get(position);
		}
		return null;
	}

	@Override
	protected String getFactPropertyType(Object property) {
		if (property instanceof Property) {
			return ((Property) property).getType();
		}
		return null;
	}

	@Override
	protected Object getFactPropertyValue(Object property) {
		if (property instanceof Property) {
			return ((Property) property).getValue();
		}
		return null;
	}

	@Override
	protected int getNrOfFactProperties(Object fact) {
		if (fact instanceof Fact) {
			return ((Fact) fact).getProperties().size();
		}
		return 0;
	}

	@Override
	protected List<Object> getRuleConditions(Object rule) {
		if (rule instanceof Rule) {
			List<Condition> conditions = ((Rule) rule).getConditions();
			return new ArrayList<Object>(conditions);
		}
		return null;
	}

	@Override
	protected List<Object> getRuleConsequences(Object rule) {
		if (rule instanceof Rule) {
			List<Condition> consequences = ((Rule) rule).getConsequences();
			return new ArrayList<Object>(consequences);
		}
		return null;
	}

	@Override
	protected RuleOperator getRuleOperator(Object rule) {
		if (rule instanceof Rule) {
			return ((Rule) rule).getRuleOperator();
		}
		return null;
	}

	@Override
	protected boolean isFactPropertyMandatory(Object property) {
		if (property instanceof Property) {
			return ((Property) property).isMandatory();
		}
		return false;
	}

	@Override
	protected boolean propertyRequiresInputFromUser(Object property) {
		if (property instanceof Property) {
			return ((Property) property).isRequiresUserInput();
		}
		return false;
	}

	@Override
	protected void setConditionParameter(Object clause, Object parameter) {
		if (clause instanceof Condition) {
			((Condition) clause).setParameter((Parameter) parameter);
		}

	}

	@Override
	protected void setFactPropertyValue(Object property, Object value) {
		if (property instanceof Property) {
			((Property) property).setValue(String.valueOf(value));
		}
	}

}
