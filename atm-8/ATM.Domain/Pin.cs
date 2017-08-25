using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ATM.Domain
{
    public class Pin : CreditCard
    {
        public int PinCode {get; set;}
    }
}
