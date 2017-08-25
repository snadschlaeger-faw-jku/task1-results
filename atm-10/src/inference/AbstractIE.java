package inference;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import inference.model.Condition;
import inference.model.Fact;
import inference.model.Property;
import inference.model.Rule;
import inference.model.Consequence;

public abstract class AbstractIE {

	protected void checkRules() {
		List<Rule> rules = getAllRules();
		for (Rule rule : rules) {
			if (checkRuleConditions(getRuleOperator(rule), getRuleConditions(rule))) {
				executeConsequences(getRuleConsequences(rule));
			}
		}
	}

	protected abstract List<Rule> getAllRules();

	protected abstract RuleOperator getRuleOperator(Rule rule);

	protected abstract List<Condition> getRuleConditions(Rule rule);

	protected abstract List<Consequence> getRuleConsequences(Rule rule);

	protected abstract String getConditionExpression(Condition condition);

	protected abstract String getConsequenceExpression(Consequence consequence);

	/**
	 * The returned parameter can be a fact object, or a String.
	 * 
	 * @param consequence
	 * @return
	 */
	protected abstract Fact getConsequenceParameter(Consequence consequence);

	protected abstract Fact getConditionParameter(Condition condition);

	private void executeConsequences(List<Consequence> consequences) {
		clearRuntimeFactStorage();
		for (Consequence consequence : consequences) {
			if (getConsequenceExpression(consequence).equals(ClauseOperators.print.name())) {
				System.out.println(getConsequenceParameter(consequence));
			} else if (getConsequenceExpression(consequence).equals(ClauseOperators.assertFact.name())) {
				Fact fact = getConsequenceParameter(consequence);
				evaluateSlots(fact);
				assertFact(fact);
			}
		}
	}

	/**
	 * Completely clean runtime storage.
	 */
	protected abstract void clearRuntimeFactStorage();

	protected abstract List<Fact> getAllFactsInRuntimeStorage();

	/**
	 * Put new fact to runtime storage.
	 * 
	 * @param fact
	 */
	protected abstract void assertFact(Fact fact);

	private void evaluateSlots(Fact fact) {
		for (Property property : getFactProperties(fact)) {
			if (propertyRequiresInputFromUser(property)) {
				try {
					System.out.println("Please enter " + getFactPropertyName(property) + ": ");
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					String s = br.readLine();
					Constructor<?> ctor = Class.forName(getFactPropertyType(property)).getConstructor(String.class);
					//???
					setFactPropertyValue(property, (String) ctor.newInstance(s));
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		}
	}

	protected abstract List<Property> getFactProperties(Fact fact);

	protected abstract String getFactName(Fact fact);

	protected abstract boolean propertyRequiresInputFromUser(Property property);

	/**
	 * This method MUST return a valid fully qualified java class name!
	 * 
	 * @param property
	 * @return
	 */
	protected abstract String getFactPropertyType(Property property);

	protected abstract void setFactPropertyValue(Property property, String value);

	protected abstract String getFactPropertyName(Property property);

	protected abstract void setConditionParameter(Condition condition, Fact parameter);

	private boolean checkRuleConditions(RuleOperator operator, List<Condition> conditions) {
		boolean conditionMet = true;
		List<Fact> retreivedFacts = new ArrayList<>();
		for (Condition clause : conditions) {
			conditionMet = conditionMet & evaluateClause(clause, retreivedFacts);
		}
		return conditionMet;
	}

	private boolean evaluateClause(Condition clause, List<Fact> retreivedFacts) {
		if (getConditionExpression(clause).equals(ClauseOperators.exists.name())) {
			if (getConditionParameter(clause) == null) {
				setConditionParameter(clause, retreivedFacts.get(0));
			}
			return exists((Fact)getConditionParameter(clause));
		} else if (getConditionExpression(clause).equals(ClauseOperators.take.name())) {
			Fact fact = getFirstFact(getAllFactsInRuntimeStorage(), getConditionParameter(clause).toString());
			if (fact != null) {
				retreivedFacts.add(fact);
				return true;
			}
		}

		return false;
	}

	private Fact getFirstFact(List<Fact> inferredFacts, String factName) {
		Fact fact = null;
		int i = 0;
		while (fact == null && i < inferredFacts.size()) {
			if (getFactName(inferredFacts.get(i)).equals(factName)) {
				fact = inferredFacts.get(i);
			}
			i++;
		}
		return fact;
	}

	protected abstract List<Fact> getAllFacts();

	protected abstract int getNrOfFactProperties(Fact fact);

	protected abstract Property getFactPropertyOnPosition(Fact fact, int position);

	protected abstract boolean isFactPropertyMandatory(Property property);

	protected abstract String getFactPropertyValue(Property property);

	private boolean exists(Fact factToCheck) {
		List<Fact> facts = getAllFacts();
		for (Fact fact : facts) {
			boolean factExists = true;

			factExists = factExists && getFactName(fact).equals(getFactName(factToCheck));
			factExists = factExists && (getNrOfFactProperties(fact) == getNrOfFactProperties(factToCheck));

			for (int i = 0; i < getNrOfFactProperties(fact); i++) {
				Property slot = getFactPropertyOnPosition(factToCheck, i);
				if (isFactPropertyMandatory(slot)) {
					Property slotToCheck = getFactPropertyOnPosition(factToCheck, i);

					factExists = factExists && getFactPropertyName(slot).equals(getFactPropertyName(slotToCheck));
					factExists = factExists && getFactPropertyType(slot).equals(getFactPropertyType(slotToCheck));
					factExists = factExists && getFactPropertyValue(slot).equals(getFactPropertyValue(slotToCheck));
				}
			}

			if (factExists) {
				return true;
			}
		}

		return false;
	}

}
