package inference.model;

public class CreditCard {
	
	String creditCardNr;
	String pinNr;
	
	Account account;

	public String getCreditCardNr() {
		return creditCardNr;
	}

	public void setCreditCardNr(String creditCardNr) {
		this.creditCardNr = creditCardNr;
	}

	public String getPinNr() {
		return pinNr;
	}

	public void setPinNr(String pinNr) {
		this.pinNr = pinNr;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
