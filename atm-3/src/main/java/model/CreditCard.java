package main.java.model;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class CreditCard implements Entity {

	public String number;
	public Pin pin;
	public Account account;

	public CreditCard(String cardNr, String pin, String balance) {
		this.number = cardNr;
		this.pin = new Pin(pin);
		this.account = new Account(balance);
	}

	public CreditCard(String cardNr) {
		this.number = cardNr;
	}

	public CreditCard(String cardNr, String pin) {
		this.number = cardNr;
		this.pin = new Pin(pin);
	}

	@Override
	public String toString() {
		return "CreditCard [number=" + number + ", pin=" + pin + ", account=" + account + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCard other = (CreditCard) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

	@Override
	public List<Field> getFactProperties() {
		try {
			return Arrays.asList(this.getClass().getField("number"));
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
