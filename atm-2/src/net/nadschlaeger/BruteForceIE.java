package net.nadschlaeger;

import java.util.List;

import net.nadschlaeger.model.Action;
import net.nadschlaeger.model.Condition;
import net.nadschlaeger.model.Fact;
import net.nadschlaeger.model.Property;
import net.nadschlaeger.model.Rule;
import net.nadschlaeger.service.FactStorage;
import net.nadschlaeger.service.RuleService;

/**
 * Created by snadschlaeger on 28.12.2016.
 */
public class BruteForceIE extends AbstractIE {

	FactStorage runtimeStorage=new FactStorage("runtime");
	FactStorage persitedStorage=new FactStorage("persited");
	RuleService ruleService=new RuleService(persitedStorage);

	@Override
	protected void assertFact(Fact fact) {
		runtimeStorage.assertFact(fact);

	}

	@Override
	protected void clearRuntimeFactStorage() {
		runtimeStorage.clear();

	}

	@Override
	protected List<Fact> getAllFacts() {
		return persitedStorage.getAllFacts();
	}

	@Override
	protected List<Fact> getAllFactsInRuntimeStorage() {
		return runtimeStorage.getAllFacts();
	}

	@Override
	protected List<Rule> getAllRules() {
		return ruleService.getAllRules();
	}

	@Override
	protected String getConditionExpression(Condition condition) {
		return condition.getOperator().name();
	}

	@Override
	protected Fact getConditionParameter(Condition condition) {
		return condition.getParameter();
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
	protected String getFactName(Fact fact) {
		return fact.getName();
	}

	@Override
	protected List<Property> getFactProperties(Fact fact) {
		return fact.getProperties();
	}

	@Override
	protected String getFactPropertyName(Property property) {
		return property.getName();
	}

	@Override
	protected Property getFactPropertyOnPosition(Fact fact, int position) {
		//TODO rangecheck
		return 		fact.getProperties().get(position);
	}

	@Override
	protected String getFactPropertyType(Property property) {
		return property.getName();
	}

	@Override
	protected Object getFactPropertyValue(Property property) {
		return property.getValue();
	}

	@Override
	protected int getNrOfFactProperties(Fact fact) {
		return fact.getPropertiesCount();
	}

	@Override
	protected List<Condition> getRuleConditions(Rule rule) {
		return rule.getConditions();
	}

	@Override
	protected List<Action> getRuleConsequences(Rule rule) {
		return rule.getConsequences();
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
		return property.isRequiresInputFromUser();
	}

	@Override
	protected void setConditionParameter(Condition condition, Fact parameter) {
		if(condition!=null && parameter!=null){
			condition.setParameter(parameter);
		}

	}

	@Override
	protected void setFactPropertyValue(Property property, Object value) {
		if(property!=null){
			property.setValue(value);
		}

	}

	public void start(){
		checkRules();
	}


}
