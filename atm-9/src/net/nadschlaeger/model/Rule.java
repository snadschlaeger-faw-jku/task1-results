package net.nadschlaeger.model;

import java.util.ArrayList;
import java.util.List;

import net.nadschlaeger.RuleOperator;

public class Rule {

	private RuleOperator ruleOperator;

	private List<Condition> conditions = new ArrayList<>();

	private List<Condition> consequences = new ArrayList<>();

	public RuleOperator getRuleOperator() {
		return ruleOperator;
	}

	public void setRuleOperator(RuleOperator ruleOperator) {
		this.ruleOperator = ruleOperator;
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public List<Condition> getConsequences() {
		return consequences;
	}

	public void setConsequences(List<Condition> consequences) {
		this.consequences = consequences;
	}

}
