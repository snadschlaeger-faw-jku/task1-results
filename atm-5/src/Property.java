

public class Property<T> {

    private final String name;
    private T value;
    private final boolean mandatory;

    public Property(String name, T value)
    {
        this(name, value, true);
    }

    public String getName() {
        return name;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Property(String name, T value, boolean mandatory) {
        this.name = name;
        this.value = value;
        this.mandatory = mandatory;
    }

    public T getValue() {
        return value;
    }

    public String getValueClassName()
    {
        return value.getClass().getCanonicalName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Property property = (Property) o;

        return name != null ? name.equals(property.name) : property.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public boolean isMandatory() {
        return mandatory;
    }
}