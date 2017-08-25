package net.nadschlaeger;

import java.util.List;

public class Rule {

	ClauseOperators co;
	List<Object> Conditions;
	List<Object> Actions;
		

	public Rule(ClauseOperators co, List<Object> conditions, List<Object> actions) {
		super();
		this.co = co;
		Conditions = conditions;
		Actions = actions;
	}
	
	
	public ClauseOperators getCo() {
		return co;
	}
	public void setCo(ClauseOperators co) {
		this.co = co;
	}
	public List<Object> getConditions() {
		return Conditions;
	}
	public void setConditions(List<Object> conditions) {
		Conditions = conditions;
	}
	public List<Object> getActions() {
		return Actions;
	}
	public void setActions(List<Object> actions) {
		Actions = actions;
	}
	
	

}
