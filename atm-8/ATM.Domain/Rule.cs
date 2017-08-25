using ATM.Logic;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ATM.Domain
{
    public class Rule
    {
        public ClauseOperators Operator { get; set; }
        public List<object> Conditions { get; set; }
        public RuleOperator RuleOperator { get; set; }
        public List<object> Actions { get; set; }
    }
}
