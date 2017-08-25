package inference.model;

import inference.RuleOperator;

public class Action implements Consequence {
	
	RuleOperator expression;
	Fact parameter;
	
	@Override
	public RuleOperator getExpression() {
		return expression;
	}
	@Override
	public void setExpression(RuleOperator expression) {
		this.expression = expression;
	}
	@Override
	public Fact getParameter() {
		return parameter;
	}
	@Override
	public void setParameter(Fact parameter) {
		this.parameter = parameter;
	}
	@Override
	public String getStringExpression() {
		return expression.name();
	}

}
