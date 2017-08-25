package inference.model;

import inference.RuleOperator;

public interface Consequence {
	public RuleOperator getExpression(); 
	public void setExpression(RuleOperator expression); 
	public Fact getParameter(); 
	public void setParameter(Fact parameter);
	public String getStringExpression(); 
	
}
