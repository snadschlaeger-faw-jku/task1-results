package net.snadschlaeger.inference.model;

import net.snadschlaeger.inference.ClauseOperator;

public class Action extends Model {

	private ClauseOperator operator;

	private Fact parameter;

	public static Action create(ClauseOperator operator) {
		return new Action(operator);
	}

	public Action(ClauseOperator operator) {
		super();
		this.operator = operator;
	}

	public ClauseOperator getOperator() {
		return operator;
	}

	public Action setOperator(ClauseOperator operator) {
		this.operator = operator;
		return this;
	}

	public Fact getParameter() {
		return parameter;
	}

	public Action setParameter(Fact parameter) {
		this.parameter = parameter;
		return this;
	}

}
