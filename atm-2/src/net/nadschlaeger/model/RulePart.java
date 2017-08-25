package net.nadschlaeger.model;

import net.nadschlaeger.ClauseOperators;

public abstract class RulePart {



	protected Fact parameter;
	protected  ClauseOperators operator;


	public ClauseOperators getOperator() {
		return operator;
	}
	public Fact getParameter() {
		return parameter;
	}public void setParameter(Fact parameter) {
		this.parameter = parameter;
	}

}
