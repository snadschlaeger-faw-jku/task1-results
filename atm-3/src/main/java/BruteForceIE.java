package main.java;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.java.model.Entity;
import main.java.model.Rule;

/**
 * Created by snadschlaeger on 28.12.2016.
 */
public class BruteForceIE extends AbstractIE {

	@Override
	protected void assertFact(Object fact) {
		Storage.runtimeData.add((Entity) fact);
	}

	@Override
	protected void clearRuntimeFactStorage() {
		Storage.runtimeData.clear();
	}

	@Override
	protected List<Object> getAllFacts() {
		List ret = new ArrayList<>(Storage.data);
		ret.addAll(Storage.runtimeData);
		return ret;
	}

	@Override
	protected List<Object> getAllFactsInRuntimeStorage() {
		return new ArrayList<>(Storage.runtimeData);
	}

	@Override
	protected List<Object> getAllRules() {
		return new ArrayList<>(Storage.rules);
	}

	@Override
	protected String getConditionExpression(Object condition) {
		return ((Rule) condition).clauseOperator.name();
	}

	@Override
	protected Object getConditionParameter(Object condition) {
		return ((Rule) condition).parameter;
	}

	@Override
	protected String getConsequenceExpression(Object consequence) {
		return ((Rule) consequence).clauseOperator.name();
	}

	@Override
	protected Object getConsequenceParameter(Object consequence) {
		return ((Rule) consequence).parameter;
	}

	@Override
	protected String getFactName(Object fact) {
		return fact.getClass().getName();
	}

	@Override
	protected List<Object> getFactProperties(Object fact) {
		return new ArrayList<>(((Entity) fact).getFactProperties());
	}

	@Override
	protected String getFactPropertyName(Object property) {
		return ((Field) property).getName();
	}

	@Override
	protected Object getFactPropertyOnPosition(Object fact, int position) {
		return fact.getClass().getFields()[position];
	}

	@Override
	protected String getFactPropertyType(Object property) {
		return ((Field) property).getType().getName();
	}

	@Override
	protected Object getFactPropertyValue(Object fact, Object property) {
		try {
			return ((Field) property).get(fact);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected int getNrOfFactProperties(Object fact) {
		return 1;
	}

	@Override
	protected List<Object> getRuleConditions(Object rule) {
		return new ArrayList<>(((Rule) rule).conditions);
	}

	@Override
	protected List<Object> getRuleConsequences(Object rule) {
		return Arrays.asList(((Rule) rule).action);
	}

	@Override
	protected RuleOperator getRuleOperator(Object rule) {
		// TODO Auto-generated method stub
		return ((Rule) rule).operator;
	}

	@Override
	protected boolean isFactPropertyMandatory(Object property) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected boolean propertyRequiresInputFromUser(Object property) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void setConditionParameter(Object clause, Object parameter) {
		((Rule) clause).parameter = (Entity) parameter;
	}

	@Override
	protected void setFactPropertyValue(Object fact, Object property, Object value) {
		try {
			((Field) property).set(fact, value);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
