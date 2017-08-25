package atm;

public class PinCard {
	private String cardNumber;
	private String pinNumber;
	
	public String getCardNumber() {
		return cardNumber;
	}

	public String getPinNumber() {
		return pinNumber;
	}
	
	public PinCard(String cardNumber, String pinNumber){
		this.cardNumber = cardNumber;
		this.pinNumber = pinNumber;
	}
}
