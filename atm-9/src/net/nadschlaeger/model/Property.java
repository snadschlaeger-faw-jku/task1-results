package net.nadschlaeger.model;

public class Property {

	private String name;

	private String type;

	private String value;

	private boolean isMandatory;

	private boolean requiresUserInput;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isMandatory() {
		return isMandatory;
	}

	public void setMandatory(boolean isMandatory) {
		this.isMandatory = isMandatory;
	}

	public boolean isRequiresUserInput() {
		return requiresUserInput;
	}

	public void setRequiresUserInput(boolean requiresUserInput) {
		this.requiresUserInput = requiresUserInput;
	}

}
