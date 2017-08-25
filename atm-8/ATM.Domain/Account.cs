using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ATM.Domain
{
    public class Account : CreditCard
    {
        public long Balance { get; set; }
    }
}
