package main.java.model;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class Account implements Entity {

	public CreditCard card;
	public String balance;

	public Account(String balance) {
		this.balance = balance;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(CreditCard creditCard) {
		this.card = creditCard;
	}
	
	
	@Override
	public String toString() {
		return "Account [card=" + card + ", balance=" + balance + "]";
	}

	@Override
	public List<Field> getFactProperties() {
		try {
			return Arrays.asList(this.getClass().getField("balance"));
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
