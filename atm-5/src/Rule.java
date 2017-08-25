import java.util.ArrayList;
import java.util.List;

public class Rule {

    private final RuleOperator operator;
    private final List<Clause> conditions = new ArrayList<>();
    private final List<Clause> consequences = new ArrayList<>();

    // Since the RuleOperator seems not to be in use...
    public Rule()
    {
        operator = null;
    }

    public Rule(RuleOperator operator) {
        this.operator = operator;
    }

    public RuleOperator getOperator() {
        return operator;
    }

    public Rule addCondition(ClauseOperators operator, Fact fact) {
        Clause clause = new Clause(operator, fact);
        conditions.add(clause);
        return this;
    }

    public List<Clause> getConditions() {
        return new ArrayList<>(conditions);
    }

    public Rule addConsequence(ClauseOperators operator, Fact fact) {
        Clause clause = new Clause(operator, fact);
        consequences.add(clause);
        return this;
    }

    public List<Clause> getConsequences() {
        return new ArrayList<>(consequences);
    }
}
