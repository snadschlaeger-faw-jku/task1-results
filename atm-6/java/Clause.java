import java.util.List;

public class Clause {
	public ClauseOperators op;
	public Fact fact;
	public Clause(ClauseOperators op, Fact fact) {
		this.op = op;
		this.fact = fact;
	}
}