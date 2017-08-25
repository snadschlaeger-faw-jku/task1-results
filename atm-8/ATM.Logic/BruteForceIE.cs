using System;
using System.Collections.Generic;
using System.Linq;
using ATM.Domain;


namespace ATM.Logic
{
    public class BruteForceIE : AbstractIE
    {

        public List<object> RuntimeFacts { get; set; }

        protected override void AssertFact(object fact)
        {
            throw new NotImplementedException();
        }

        protected override void ClearRuntimeFactStorage()
        {
            RuntimeFacts.Clear();
        }

        protected override List<object> GetAllFacts()
        {
            return CardStore.GetAll();
        }

        protected override List<object> GetAllFactsInRuntimeStorage()
        {
            return RuntimeFacts;
        }

        protected override string GetConditionExpression(object condition)
        {
            return ((Condition)condition).Expression;
        }

        protected override object GetConditionParameter(object condition)
        {
            return ((Condition)condition).Parameter;
        }

        protected override string GetConsequenceExpression(object consequence)
        {
            return ((Domain.Action) consequence).expression;
        }

        protected override object GetConsequenceParameter(object consequence)
        {
            return ((Domain.Action)consequence).Parameter;
        }

        protected override string GetFactName(object fact)
        {
            return ((CreditCard)fact).CardNumber.ToString();
        }

        protected override List<object> GetFactProperties(object fact)
        {
            var lst = new List<object>();
            if(fact.GetType() == typeof(CreditCard))
            {
                lst.Add(((CreditCard)fact).CardNumber);
            }
            else if (fact.GetType() == typeof(Pin))
            {
                lst.Add(((Pin)fact).CardNumber);
                lst.Add(((Pin)fact).PinCode);
            }
            else if (fact.GetType() == typeof(Account))
            {
                lst.Add(((Account)fact).CardNumber);
                lst.Add(((Account)fact).Balance);
            }

            return lst;
        }

        protected override string GetFactPropertyName(object property)
        {
            return nameof(property);
        }

        protected override object GetFactPropertyOnPosition(object fact, int position)
        {
            var props = GetFactProperties(fact);
            return props.ElementAt(position);

        }

        protected override string GetFactPropertyType(object property)
        {
            return property.GetType().FullName;
        }

        protected override object GetFactPropertyValue(object property)
        {
            throw new NotImplementedException();
        }

        protected override int GetNrOfFactProperties(object fact)
        {
            return GetFactProperties(fact).Count;
        }

        protected override List<object> GetAllRules()
        {
            return RuleStore.Rules;
        }

        protected override RuleOperator GetRuleOperator(object rule)
        {
            return ((Rule)rule).RuleOperator;
        }


        protected override List<object> GetRuleConditions(object rule)
        {
            return ((Rule)rule).Conditions;
        }

        protected override List<object> GetRuleConsequences(object rule)
        {
            return ((Rule) rule).Actions;
        }

        
        protected override bool IsFactPropertyMandatory(object property)
        {
            throw new NotImplementedException();
        }

        protected override bool PropertyRequiresInputFromUser(object property)
        {
            throw new NotImplementedException();
        }

        protected override void SetConditionParameter(object condition, object parameter)
        {
            ((Condition)condition).Parameter = parameter;
        }

        protected override void SetFactPropertyValue(object property, object value)
        {
            
        }
    }
}
