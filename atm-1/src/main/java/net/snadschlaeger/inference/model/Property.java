package net.snadschlaeger.inference.model;

public class Property extends Model {

	private String name;

	private Class<?> type;

	private Object value;

	private boolean requiresUserInput;

	private boolean mandatory;

	public static Property create(String name, Class<?> type, Object value) {
		return new Property(name, type, value);
	}

	public Property(String name) {
		this(name, String.class, null);
	}

	public Property(String name, Class<?> type) {
		this(name, type, null);
	}

	public Property(String name, Class<?> type, Object value) {
		super();
		this.name = name;
		this.type = type;
		this.value = value;
		this.requiresUserInput = true;
		this.mandatory = true;
	}

	public String getName() {
		return name;
	}

	public Property setName(String name) {
		this.name = name;
		return this;
	}

	public Class<?> getType() {
		return type;
	}

	public Property setType(Class<?> type) {
		this.type = type;
		return this;
	}

	public Object getValue() {
		return value;
	}

	public Property setValue(Object value) {
		this.value = value;
		return this;
	}

	public Property setRequiresUserInput(boolean requiresUserInput) {
		this.requiresUserInput = requiresUserInput;
		return this;
	}

	public boolean isRequiresUserInput() {
		return requiresUserInput;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public Property setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
		return this;
	}

}
