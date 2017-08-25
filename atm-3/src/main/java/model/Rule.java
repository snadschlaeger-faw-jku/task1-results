package main.java.model;

import java.util.ArrayList;
import java.util.List;

import main.java.ClauseOperators;
import main.java.RuleOperator;

public class Rule {

	public ClauseOperators clauseOperator;
	public RuleOperator operator;
	public Entity parameter;
	public List<Rule> conditions = new ArrayList<>();
	
	public Rule action;

	public Rule(ClauseOperators clauseOperator, Entity parameter) {
		super();
		this.clauseOperator = clauseOperator;
		this.parameter = parameter;
	}

	@Override
	public String toString() {
		return "Rule [clauseOperator=" + clauseOperator + ", operator=" + operator + ", parameter=" + parameter
				+ ", conditions=" + conditions + ", action=" + action + "]";
	}
	
	

}
