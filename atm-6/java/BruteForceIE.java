//package net.nadschlaeger;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by snadschlaeger on 28.12.2016.
 */
public class BruteForceIE extends AbstractIE {

	List<Object> rules;
	List<Object> dbFacts;
	List<Object> rtFacts;

	public BruteForceIE(List<Object> rules, List<Object> facts) {
		this.rules = rules;
		dbFacts = facts;
	}

	@Override
	protected void assertFact(Object fact) {
		rtFacts.add(fact);
	}

	@Override
	protected void clearRuntimeFactStorage() {
		rtFacts = new ArrayList<>();
	}

	@Override
	protected List<Object> getAllFacts() {
		return dbFacts;
	}

	@Override
	protected List<Object> getAllFactsInRuntimeStorage() {
		return rtFacts;
	}

	@Override
	protected List<Object> getAllRules() {
		return rules;
	}

	@Override
	protected String getConditionExpression(Object condition) {
		return ((Clause)condition).op.name();
	}

	@Override
	protected Object getConditionParameter(Object condition) {
		return ((Clause)condition).fact;
	}

	@Override
	protected String getConsequenceExpression(Object consequence) {
		return ((Consequence)consequence).op.name();
	}

	@Override
	protected Object getConsequenceParameter(Object consequence) {
		return ((Consequence)consequence).parameter;
	}

	@Override
	protected String getFactName(Object fact) {
		return ((Fact)fact).name;
	}

	@Override
	protected List<Object> getFactProperties(Object fact) {
		return ((Fact)fact).properties;
	}

	@Override
	protected String getFactPropertyName(Object property) {
		return ((Property)property).name;
	}

	@Override
	protected Object getFactPropertyOnPosition(Object fact, int position) {
		return ((Fact)fact).properties.get(position);
	}

	@Override
	protected String getFactPropertyType(Object property) {
		return ((Property)property).type;
	}

	@Override
	protected Object getFactPropertyValue(Object property) {
		return ((Property)property).value;
	}

	@Override
	protected int getNrOfFactProperties(Object fact) {
		return ((Fact)fact).properties.size();
	}

	@Override
	protected List<Object> getRuleConditions(Object rule) {
		return ((Rule)rule).conditions;
	}

	@Override
	protected List<Object> getRuleConsequences(Object rule) {
		return ((Rule)rule).consequences;
	}

	@Override
	protected RuleOperator getRuleOperator(Object rule) {
		return ((Rule)rule).op;
	}

	@Override
	protected boolean isFactPropertyMandatory(Object property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean propertyRequiresInputFromUser(Object property) {
		return (getFactPropertyValue(property) == null);
	}

	@Override
	protected void setConditionParameter(Object clause, Object parameter) {
		((Clause) clause).fact = (Fact)parameter;
	}

	@Override
	protected void setFactPropertyValue(Object property, Object value) {
		((Property)property).value = value;
	}

}
