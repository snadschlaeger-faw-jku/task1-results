package dissItBaby;

import inout.*;
import net.nadschlaeger.*;


public class ATM {

	public static void main(String[] arg)
	{	
		Account[] acc = new Account[3];		
		acc[0] = new Account(123,123,123);
		acc[1] = new Account(456,456,456);
		acc[2] = new Account(789,789,789);
		
		int card, pin, amount;
		int cardindex=-1;
		
		Out.println("Ein lustiger Bankomat fürn Stefan, der auch funktioniert :D\n");
		Out.print("Please insert your Debit Card.\nCard-No.: ");
		card=In.readInt();
		// validate Card
		
		for(int i=0; i<acc.length; i++)
			if(acc[i].getCardnumber()==card) cardindex=i;
		
		if(cardindex==-1)
		{
			Out.println("Card does not exist - Terminated");
			System.exit(1);
		}
		
		Out.print("Please enter your PIN.\nPIN: ");
		pin=In.readInt();		
		// validate PIN
		if(acc[cardindex].getPinnumber()!=pin)
		{
			Out.println("PIN is incorrect - Terminated");
			System.exit(1);
		}
				
		Out.println("How much would you like to withdraw from your account?\nAmount: ");
		amount=In.readInt();
		// validate Withdrawal
		if(acc[cardindex].getAmount()<amount)
		{
			Out.println("You don't have enough money - Terminated");
			System.exit(1);
		}
		else
		{
			acc[cardindex].setAmount(acc[cardindex].getAmount()-amount);
			Out.println("Your new balance is: " + acc[cardindex].getAmount());
		}
		

		
	}
	
	
	
}
