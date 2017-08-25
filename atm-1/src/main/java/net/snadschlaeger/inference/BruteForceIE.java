package net.snadschlaeger.inference;

import java.util.ArrayList;
import java.util.List;

import net.snadschlaeger.inference.model.Action;
import net.snadschlaeger.inference.model.Fact;
import net.snadschlaeger.inference.model.Property;
import net.snadschlaeger.inference.model.Rule;

public class BruteForceIE extends AbstractIE {

	private List<Rule> rules = new ArrayList<>();

	private List<Fact> facts = new ArrayList<>();

	private List<Fact> runtimeFacts = new ArrayList<>();

	public List<Fact> getFacts() {
		return facts;
	}

	@Override
	protected List<Rule> getAllRules() {
		return rules;
	}

	@Override
	protected RuleOperator getRuleOperator(Rule rule) {
		return rule.getOperator();
	}

	@Override
	protected List<Action> getRuleConditions(Rule rule) {
		return rule.getConditions();
	}

	@Override
	protected List<Action> getRuleConsequences(Rule rule) {
		return rule.getActions();
	}

	@Override
	protected String getConditionExpression(Action condition) {
		return condition.getOperator().name();
	}

	@Override
	protected String getConsequenceExpression(Action consequence) {
		return consequence.getOperator().name();
	}

	@Override
	protected Fact getConsequenceParameter(Action consequence) {
		return consequence.getParameter();
	}

	@Override
	protected Fact getConditionParameter(Action condition) {
		return condition.getParameter();
	}

	@Override
	protected void clearRuntimeFactStorage() {
		runtimeFacts.clear();
	}

	@Override
	protected List<Fact> getAllFactsInRuntimeStorage() {
		return runtimeFacts;
	}

	@Override
	protected void assertFact(Fact fact) {
		runtimeFacts.add(fact);
	}

	@Override
	protected List<Property> getFactProperties(Fact fact) {
		return fact.getProperties();
	}

	@Override
	protected String getFactName(Fact fact) {
		return fact.getName();
	}

	@Override
	protected boolean propertyRequiresInputFromUser(Property property) {
		return property.isRequiresUserInput();
	}

	@Override
	protected String getFactPropertyType(Property property) {
		return property.getClass().getName();
	}

	@Override
	protected void setFactPropertyValue(Property property, Object value) {
		property.setValue(value);
	}

	@Override
	protected String getFactPropertyName(Property property) {
		return property.getName();
	}

	@Override
	protected void setConditionParameter(Action condition, Fact parameter) {
		condition.setParameter(parameter);
	}

	@Override
	protected List<Fact> getAllFacts() {
		return facts;
	}

	@Override
	protected int getNrOfFactProperties(Fact fact) {
		return fact.getProperties().size();
	}

	@Override
	protected Property getFactPropertyOnPosition(Fact fact, int position) {
		return fact.getProperties().get(position);
	}

	@Override
	protected boolean isFactPropertyMandatory(Property property) {
		return property.isMandatory();
	}

	@Override
	protected Object getFactPropertyValue(Property property) {
		return property.getValue();
	}

}
