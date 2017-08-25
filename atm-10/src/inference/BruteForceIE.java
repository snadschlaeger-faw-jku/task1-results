package inference;

import java.util.LinkedList;
import java.util.List;

import inference.model.Fact;
import inference.model.Property;
import inference.model.Rule;
import inference.model.Condition;
import inference.model.Consequence;

/**
 * Created by snadschlaeger on 28.12.2016.
 */
public class BruteForceIE extends AbstractIE {

	@Override
	protected void assertFact(Fact fact) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void clearRuntimeFactStorage() {
		// TODO Auto-generated method stub

	}

	@Override
	protected List<Fact> getAllFacts() {
		return null;
	}

	@Override
	protected List<Fact> getAllFactsInRuntimeStorage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<Rule> getAllRules() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getConditionExpression(Condition condition) {
		return condition.getStringExpression();
	}

	@Override
	protected Fact getConditionParameter(Condition condition) {
		return condition.getParameter();
	}

	@Override
	protected String getConsequenceExpression(Consequence consequence) {
		return consequence.getStringExpression();
	}

	@Override
	protected Fact getConsequenceParameter(Consequence consequence) {
		return consequence.getParameter();
	}

	@Override
	protected String getFactName(Fact fact) {
		return fact.getName();
	}

	@Override
	protected List<Property> getFactProperties(Fact fact) {
		return fact.getProperties();
	}

	@Override
	protected String getFactPropertyName(Property property) {
		return property.getKey();
	}

	@Override
	protected Property getFactPropertyOnPosition(Fact fact, int position) {
		return fact.getProperty(position);
	}

	@Override
	protected String getFactPropertyType(Property property) {
		return property.getClass().getTypeName();
	}

	@Override
	protected String getFactPropertyValue(Property property) {
		return property.getValue();
	}

	@Override
	protected int getNrOfFactProperties(Fact fact) {
		return fact.getProperties().size();
	}

	@Override
	protected List<Condition> getRuleConditions(Rule rule) {
		return rule.getConditions();
	}

	@Override
	protected List<Consequence> getRuleConsequences(Rule rule) {
		List<Consequence> consequences = new LinkedList<Consequence>();
		consequences.addAll(rule.getConditions());
		consequences.addAll(rule.getActions());
		return consequences;
	}

	@Override
	protected RuleOperator getRuleOperator(Rule rule) {
		return rule.getOperator();
	}

	@Override
	protected boolean isFactPropertyMandatory(Property property) {
		return property.isMandatory();
	}

	@Override
	protected boolean propertyRequiresInputFromUser(Property property) {
		return property.requiresUserInput();
	}

	@Override
	protected void setConditionParameter(Condition clause, Fact parameter) {
		clause.setParameter(parameter);
	}

	@Override
	protected void setFactPropertyValue(Property property, String value) {
		property.setValue(value);
	}

}
