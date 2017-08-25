package inference.model;

import java.util.List;

public class Property {
	String key;
	String  value;
	boolean requiresUserInput;
	boolean mandatory;
	
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean requiresUserInput() {
		return requiresUserInput;
	}
	public void setRequiresUserInput(boolean requiresUserInput) {
		this.requiresUserInput = requiresUserInput;
	}
	public boolean isMandatory() {
		return mandatory;
	}
	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}
	
}
