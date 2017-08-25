
public class Clause {
    private final ClauseOperators operator;
    private Fact fact;

    public Clause(ClauseOperators operator, Fact fact) {
        this.operator = operator;
        this.fact = fact;
    }

    public Fact getFact() {
        return fact;
    }

    public void setFact(Fact fact) {
        this.fact = fact;
    }

    public ClauseOperators getOperator() {
        return operator;
    }

}
