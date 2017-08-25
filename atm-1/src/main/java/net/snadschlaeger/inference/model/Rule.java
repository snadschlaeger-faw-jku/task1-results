package net.snadschlaeger.inference.model;

import java.util.ArrayList;
import java.util.List;

import net.snadschlaeger.inference.RuleOperator;

public class Rule extends Model {

	private RuleOperator operator;

	private List<Action> actions;

	private List<Action> conditions;

	public static Rule create() {
		return new Rule();
	}

	public Rule() {
		this.operator = RuleOperator.AND;
		this.actions = new ArrayList<>();
		this.conditions = new ArrayList<>();
	}

	public RuleOperator getOperator() {
		return operator;
	}

	public Rule setOperator(RuleOperator operator) {
		this.operator = operator;
		return this;
	}

	public List<Action> getActions() {
		return actions;
	}

	public Rule setActions(List<Action> actions) {
		this.actions = actions;
		return this;
	}

	public Rule addAction(Action action) {
		this.actions.add(action);
		return this;
	}

	public List<Action> getConditions() {
		return conditions;
	}

	public Rule setConditions(List<Action> conditions) {
		this.conditions = conditions;
		return this;
	}

	public Rule addCondition(Action condition) {
		this.conditions.add(condition);
		return this;
	}

}
