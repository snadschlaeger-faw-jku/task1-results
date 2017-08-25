package atm;

public class Account {
	private String accountNumber;
	private PinCard pin;
	private double balance;
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public PinCard getPin() {
		return pin;
	}


	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Account(String accountNumber, PinCard pin, double balance){
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.balance = balance;
	}
}
