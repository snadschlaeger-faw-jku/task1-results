package net.nadschlaeger.model;

public class Property {

	private final String name;
	private   boolean requiresInputFromUser=false;
	private boolean isMandatory=false;
	private Object value;

	public Property(String name, boolean requiresInputFromUser, Object value, boolean isMandatory) {
		super();
		this.name = name;
		this.requiresInputFromUser = requiresInputFromUser;
		this.value = value;
		this.isMandatory=isMandatory;
	}public String getName() {
		return name;
	}
	public Object getValue() {
		return value;
	}
	public boolean isMandatory() {
		return isMandatory;
	}

	public boolean isRequiresInputFromUser() {
		return requiresInputFromUser;
	}
	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Property [name=" + name + ", requiresInputFromUser=" + requiresInputFromUser + ", isMandatory="
				+ isMandatory + ", value=" + value + "]";
	}

}
