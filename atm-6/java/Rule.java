import java.util.List;

public class Rule {
	public RuleOperator op;
	public List<Object> conditions;
	public List<Object> consequences;

	public Rule(RuleOperator op, List<Object> conditions, List<Object> consequences) {
		this.op = op;
		this.conditions = conditions;
		this.consequences = consequences;
	}
}