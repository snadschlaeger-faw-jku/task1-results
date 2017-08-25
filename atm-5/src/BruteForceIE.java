import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by snadschlaeger on 28.12.2016.
 */
public class BruteForceIE extends AbstractIE {

	private final Set<Fact> facts = new HashSet<>();
	private final Set<Fact> runtimeFacts = new HashSet<>();

	private final Set<Rule> rules = new HashSet<>();

	public void addFact(Fact fact)
	{
		facts.add(fact);
	}

	public void addRule(Rule rule)
	{
		rules.add(rule);
	}

	@Override
	protected void assertFact(Object fact) {
		Fact f = getFact(fact);
		facts.add(f);
	}

	@Override
	protected void clearRuntimeFactStorage() {
		runtimeFacts.clear();
	}

	@Override
	protected List<Object> getAllFacts() {
		return new ArrayList<>(facts);
	}

	@Override
	protected List<Object> getAllFactsInRuntimeStorage() {
		return new ArrayList<>(runtimeFacts);
	}

	@Override
	protected List<Object> getAllRules() {
		return new ArrayList<>(rules);
	}

	@Override
	protected String getConditionExpression(Object condition) {
		Clause c = getClause(condition);
		return c.getOperator().name();
	}

	@Override
	protected Object getConditionParameter(Object condition) {
		Clause c = getClause(condition);
		return c.getFact();
	}

	@Override
	protected String getConsequenceExpression(Object consequence) {
		Clause c = getClause(consequence);
		return c.getOperator().name();
	}

	@Override
	protected Object getConsequenceParameter(Object consequence) {
		Clause c = getClause(consequence);
		return c.getFact();
	}

	@Override
	protected String getFactName(Object fact) {
		Fact f = getFact(fact);
		return f.getName();
	}

	@Override
	protected List<Object> getFactProperties(Object fact) {
		Fact f = getFact(fact);
		return new ArrayList<>(f.getProperties());
	}

	@Override
	protected String getFactPropertyName(Object property) {
		Property p = getProperty(property);
		return p.getName();
	}

	@Override
	protected Object getFactPropertyOnPosition(Object fact, int position) {
		Fact f = getFact(fact);
		return f.getProperty(position);
	}

	@Override
	protected String getFactPropertyType(Object property) {
		Property p = getProperty(property);
		return p.getValueClassName();
	}

	@Override
	protected Object getFactPropertyValue(Object property) {
		Property p = getProperty(property);
		return p.getValue();
	}

	@Override
	protected int getNrOfFactProperties(Object fact) {
		Fact f = getFact(fact);
		return f.getNumProperties();
	}

	@Override
	protected List<Object> getRuleConditions(Object rule) {
		Rule r = getRule(rule);
		return new ArrayList<>(r.getConditions());
	}

	@Override
	protected List<Object> getRuleConsequences(Object rule) {
		Rule r = getRule(rule);
		return new ArrayList<>(r.getConsequences());
	}

	@Override
	protected RuleOperator getRuleOperator(Object rule) {
		Rule r = getRule(rule);
		return r.getOperator();
	}

	@Override
	protected boolean isFactPropertyMandatory(Object property) {
		Property p = getProperty(property);
		return p.isMandatory();
	}

	@Override
	protected boolean propertyRequiresInputFromUser(Object property) {
		Property p = getProperty(property);
		return p == null;
	}

	@Override
	protected void setConditionParameter(Object clause, Object parameter) {
		Clause c = getClause(clause);
		Fact f = getFact(parameter);
		c.setFact(f);
	}

	@Override
	protected void setFactPropertyValue(Object property, Object value) {
		Property p = getProperty(property);
		p.setValue(value);
	}

	private Fact getFact(Object o)
	{
		if(o instanceof Fact)
		{
			return (Fact) o;
		}
		throw new IllegalArgumentException("The passed argument must be of class Fact");
	}

	private Property getProperty(Object o)
	{
		if(o instanceof Property)
		{
			return (Property) o;
		}
		throw new IllegalArgumentException("The passed argument must be of class Property");
	}

	private Rule getRule(Object o)
	{
		if(o instanceof Rule)
		{
			return (Rule) o;
		}
		throw new IllegalArgumentException("The passed argument must be of class Rule");
	}

	private Clause getClause(Object o)
	{
		if(o instanceof Clause)
		{
			return (Clause) o;
		}
		throw new IllegalArgumentException("The passed argument must be of class Clause");
	}

}
