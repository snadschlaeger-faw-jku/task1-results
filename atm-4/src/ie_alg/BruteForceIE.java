package ie_alg;

import java.util.ArrayList;
import java.util.List;

import atm.Card;
import atm.PinCard;
import atm.Rule;
import atm.WithdrawMoney;

public class BruteForceIE extends AbstractIE {

	@Override
	protected void assertFact(Object fact) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void clearRuntimeFactStorage() {
		// TODO Auto-generated method stub

	}

	@Override
	protected List<Object> getAllFacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<Object> getAllFactsInRuntimeStorage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<Object> getAllRules() {
		List<Object> rules = new ArrayList<Object>();
		
		// rule 1
		Rule rule = new Rule(ClauseOperators.exists, ClauseOperators.assertFact);
		rule.conditions.add(Card.class.getSimpleName());
		rule.actions.add(PinCard.class.getSimpleName());
		rules.add(rule);
		
		// rule 2
		rule = new Rule(ClauseOperators.exists, ClauseOperators.assertInput);
		rule.conditions.add(PinCard.class.getSimpleName());
		rule.actions.add(WithdrawMoney.class.getSimpleName());
		rules.add(rule);
		
		return rules;
	}

	@Override
	protected String getConditionExpression(Object condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object getConditionParameter(Object condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getConsequenceExpression(Object consequence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object getConsequenceParameter(Object consequence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getFactName(Object fact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<Object> getFactProperties(Object fact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getFactPropertyName(Object property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object getFactPropertyOnPosition(Object fact, int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getFactPropertyType(Object property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object getFactPropertyValue(Object property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int getNrOfFactProperties(Object fact) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected List<Object> getRuleConditions(Object rule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<Object> getRuleConsequences(Object rule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected LogicOperator getRuleOperator(Object rule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isFactPropertyMandatory(Object property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean propertyRequiresInputFromUser(Object property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void setConditionParameter(Object clause, Object parameter) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setFactPropertyValue(Object property, Object value) {
		// TODO Auto-generated method stub

	}

}
