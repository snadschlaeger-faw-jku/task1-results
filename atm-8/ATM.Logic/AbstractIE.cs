using System;
using System.Collections.Generic;
using ATM.Domain;

namespace ATM.Logic
{
    public abstract class AbstractIE
    {
        protected void CheckRules()
        {
            List<Object> rules = GetAllRules();
            foreach (Object rule in rules)
            {
                if (CheckRuleConditions(GetRuleOperator(rule), GetRuleConditions(rule)))
                {
                    ExecuteConsequences(GetRuleConsequences(rule));
                }
            }
        }

        protected abstract List<Object> GetAllRules();

        protected abstract RuleOperator GetRuleOperator(object rule);

        protected abstract List<Object> GetRuleConditions(Object rule);

        protected abstract List<Object> GetRuleConsequences(Object rule);

        protected abstract String GetConditionExpression(Object condition);

        protected abstract String GetConsequenceExpression(Object consequence);

        /**
         * The returned parameter can be a fact object, or a String.
         * 
         * @param consequence
         * @return
         */
        protected abstract Object GetConsequenceParameter(Object consequence);

        protected abstract Object GetConditionParameter(Object condition);

        private void ExecuteConsequences(List<Object> consequences)
        {
            ClearRuntimeFactStorage();
            foreach (Object consequence in consequences)
            {
                if (GetConsequenceExpression(consequence) == (ClauseOperators.Print.ToString()))
                {
                    Console.WriteLine(GetConsequenceParameter(consequence));
                }
                else if (GetConsequenceExpression(consequence) == (ClauseOperators.AssertFact.ToString()))
                {
                    Object fact = (Object)GetConsequenceParameter(consequence);
                    EvaluateSlots(fact);
                    AssertFact(fact);
                }
            }
        }

        /**
         * Completely clean runtime storage.
         */
        protected abstract void ClearRuntimeFactStorage();

        protected abstract List<Object> GetAllFactsInRuntimeStorage();

        /**
         * Put new fact to runtime storage.
         * 
         * @param fact
         */
        protected abstract void AssertFact(Object fact);

        private void EvaluateSlots(Object fact)
        {
            foreach (Object property in GetFactProperties(fact))
            {
                if (PropertyRequiresInputFromUser(property))
                {
                    try
                    {
                        Console.WriteLine("Please enter " + GetFactPropertyName(property) + ": ");
                        String s = Console.ReadLine();
                        Type type = Type.GetType(GetFactPropertyType(property), true);
                        var instance = Activator.CreateInstance(type, s);
                        SetFactPropertyValue(property, instance);
                    }
                    catch (Exception ex)
                    {
                        Console.Error.WriteLine(ex);
                    }

                }
            }
        }

        protected abstract List<Object> GetFactProperties(Object fact);

        protected abstract String GetFactName(Object fact);

        protected abstract bool PropertyRequiresInputFromUser(Object property);

        /**
         * This method MUST return a valid fully qualified java class name!
         * 
         * @param property
         * @return
         */
        protected abstract String GetFactPropertyType(Object property);

        protected abstract void SetFactPropertyValue(Object property, Object value);

        protected abstract String GetFactPropertyName(Object property);

        protected abstract void SetConditionParameter(Object condition, Object parameter);

        private bool CheckRuleConditions(RuleOperator ruleOp, List<Object> conditions)
        {
            bool conditionMet = true;
            IList<Object> retreivedFacts = new List<Object>();
            foreach (Object clause in conditions)
            {
                conditionMet = conditionMet & EvaluateClause(clause, retreivedFacts);
            }
            return conditionMet;
        }

        private bool EvaluateClause(Object clause, IList<Object> retreivedFacts)
        {
            if (GetConditionExpression(clause) == (ClauseOperators.Exists.ToString()))
            {
                if (GetConditionParameter(clause) == null)
                {
                    SetConditionParameter(clause, retreivedFacts[0]);
                }
                return Exists(GetConditionParameter(clause));
            }
            else if (GetConditionExpression(clause) == (ClauseOperators.Take.ToString()))
            {
                Object fact = GetFirstFact(GetAllFactsInRuntimeStorage(), GetConditionParameter(clause).ToString());
                if (fact != null)
                {
                    retreivedFacts.Add(fact);
                    return true;
                }
            }

            return false;
        }

        private Object GetFirstFact(List<Object> inferredFacts, String factName)
        {
            Object fact = null;
            int i = 0;
            while (fact == null && i < inferredFacts.Count)
            {
                if (GetFactName(inferredFacts[i]) == (factName))
                {
                    fact = inferredFacts[i];
                }
                i++;
            }
            return fact;
        }

        protected abstract List<Object> GetAllFacts();

        protected abstract int GetNrOfFactProperties(Object fact);

        protected abstract Object GetFactPropertyOnPosition(Object fact, int position);

        protected abstract bool IsFactPropertyMandatory(Object property);

        protected abstract Object GetFactPropertyValue(Object property);

        private bool Exists(Object factToCheck)
        {
            List<Object> facts = GetAllFacts();
            foreach (Object fact in facts)
            {
                bool factExists = true;

                factExists = factExists && GetFactName(fact) == (GetFactName(factToCheck));
                factExists = factExists && (GetNrOfFactProperties(fact) == GetNrOfFactProperties(factToCheck));

                for (int i = 0; i < GetNrOfFactProperties(fact); i++)
                {
                    Object slot = GetFactPropertyOnPosition(fact, i);
                    if (IsFactPropertyMandatory(slot))
                    {
                        Object slotToCheck = GetFactPropertyOnPosition(factToCheck, i);

                        factExists = factExists && GetFactPropertyName(slot) == (GetFactPropertyName(slotToCheck));
                        factExists = factExists && GetFactPropertyType(slot) == (GetFactPropertyType(slotToCheck));
                        factExists = factExists && GetFactPropertyValue(slot) == (GetFactPropertyValue(slotToCheck));
                    }
                }

                if (factExists)
                {
                    return true;
                }
            }

            return false;
        }
    }
}
