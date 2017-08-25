package dissItBaby;

public class Account {
	
	protected int cardnumber;
	protected int pin;
	protected int amount;	
	
	public Account(int cardnumber, int pinnumber, int amount) {
		super();
		this.cardnumber = cardnumber;
		this.pin = pinnumber;
		this.amount = amount;
	}
	
	public int getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(int cardnumber) {
		this.cardnumber = cardnumber;
	}
	public int getPinnumber() {
		return pin;
	}
	public void setPinnumber(int pinnumber) {
		this.pin = pinnumber;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	

}
