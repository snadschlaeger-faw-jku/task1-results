using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using ATM.Domain;

namespace ATM.DataStore
{
    public static class CardStore
    {
        public static List<CreditCard> Cards { get; set; } = new List<CreditCard>
        {
            new CreditCard {CardNumber = 123},
            new CreditCard {CardNumber = 456},
            new CreditCard {CardNumber = 789},
            new CreditCard {CardNumber = 987},
            new CreditCard {CardNumber = 654},
            new CreditCard {CardNumber = 321},
            new CreditCard {CardNumber = 159}
        };



        public static List<Pin> Pins { get; set; }= new List<Pin>
        {
            new Pin {CardNumber = 123, PinCode = 1111},
            new Pin {CardNumber = 456, PinCode = 2222},
            new Pin {CardNumber = 789, PinCode = 3333},
            new Pin {CardNumber = 987, PinCode = 4444},
            new Pin {CardNumber = 654, PinCode = 5555},
            new Pin {CardNumber = 321, PinCode = 6666},
            new Pin {CardNumber = 159, PinCode = 7777}
        };

        public static List<Account> Accounts { get; set; }= new List<Account>
        {
            new Account {CardNumber =123, Balance = 500},
            new Account {CardNumber =456, Balance = 100},
            new Account {CardNumber =789, Balance = 0},
            new Account {CardNumber =987, Balance = 15000},
            new Account {CardNumber =654, Balance = 300},
            new Account {CardNumber =321, Balance = 250},
            new Account {CardNumber =159, Balance = 100}
        };

        public static List<object> GetAll()
        {
            var lst = new List<object>();
            lst.AddRange(Cards);
            lst.AddRange(Pins);
            lst.AddRange(Accounts);
        }

        public static void ClearAll()
        {
            Cards.Clear();
            Pins.Clear();
            Accounts.Clear();
        }

    }

}
