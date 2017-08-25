package net.nadschlaeger.model;

import net.nadschlaeger.ClauseOperators;

public class Action extends RulePart{

	public Action(ClauseOperators operator, Fact parameter) {
		super();
		this.operator = operator;
		this.parameter = parameter;
	}

	@Override
	public String toString() {
		return "Action [operator=" + operator + ", parameter=" + parameter + "]";
	}

}
