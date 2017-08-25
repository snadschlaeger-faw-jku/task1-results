package inference.model;

import java.util.List;

import inference.RuleOperator;

public abstract class Rule {
	
	RuleOperator operator;
	
	List<Condition> conditions;
	List<Action> actions;
	
	
	public RuleOperator getOperator() {
		return operator;
	}
	public void setOperator(RuleOperator operator) {
		this.operator = operator;
	}
	public List<Condition> getConditions() {
		return conditions;
	}
	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}
	public List<Action> getActions() {
		return actions;
	}
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	
	
}
