package net.nadschlaeger.model;

import net.nadschlaeger.ClauseOperators;

public class Condition extends RulePart {

	public Condition(ClauseOperators operator, Fact parameter) {
		super();
		this.operator = operator;
		this.parameter = parameter;
	}

	@Override
	public String toString() {
		return "Condition [operator=" + operator + ", parameter=" + parameter + "]";
	}



}
