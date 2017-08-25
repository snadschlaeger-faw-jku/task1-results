package atm;

import ie_alg.ClauseOperators;

import java.util.ArrayList;
import java.util.List;

public class Rule {
	public ClauseOperators clauseOperatorIF;
	public List<String> conditions;
	public ClauseOperators clauseOperatorTHEN;
	public List<String> actions;
	
	public Rule(ClauseOperators clauseOperatorIF, ClauseOperators clauseOperatorTHEN){
		this.clauseOperatorIF = clauseOperatorIF;
		this.clauseOperatorTHEN = clauseOperatorTHEN;
		this.conditions = new ArrayList<String>();
		this.actions = new ArrayList<String>();
	}
}
