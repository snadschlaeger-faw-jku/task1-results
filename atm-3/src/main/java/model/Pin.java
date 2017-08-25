package main.java.model;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class Pin implements Entity {
	
	public CreditCard card;
	public String code;
	
	public Pin(CreditCard card) {
		this.card=card;
	}
	
	public Pin(CreditCard card, String pin) {
		this.card=card;
		this.code = pin;
	}

	public Pin(String pin) {
		this.code = pin;
	}

	

	@Override
	public String toString() {
		return "Pin [card=" + card + ", code=" + code + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		Pin other = (Pin) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	
	
	@Override
	public List<Field> getFactProperties() {
		try {
			return Arrays.asList(this.getClass().getField("code"));
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
