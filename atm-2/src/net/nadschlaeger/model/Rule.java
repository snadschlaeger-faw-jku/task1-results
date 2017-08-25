package net.nadschlaeger.model;

import java.util.ArrayList;
import java.util.List;

import net.nadschlaeger.RuleOperator;

public class Rule {

	private RuleOperator operator;
	private  List<Condition>conditions=new ArrayList<>();
	private  List<Action>consequences=new ArrayList<>();

	public Rule(RuleOperator operator, List<Condition> conditions, List<Action> consequences) {
		super();
		this.operator = operator;
		this.conditions = conditions;
		this.consequences = consequences;
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public List<Action> getConsequences() {
		return consequences;
	}

	public RuleOperator getOperator() {
		return operator;
	}

	public void setOperator(RuleOperator operator) {
		this.operator = operator;
	}


	@Override
	public String toString() {
		return "Rule [operator=" + operator + ", conditions=" + conditions + ", consequences=" + consequences + "]";
	}



}
