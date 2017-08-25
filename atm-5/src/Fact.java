import java.util.*;

public class Fact {
    private final String name;

    private final List<Property> properties = new ArrayList<>();

    public Fact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Property> getProperties()
    {
        return new ArrayList<>(properties);
    }

    public int getPropertyIndex(String name)
    {
        Property property = new Property(name, null);
        return properties.indexOf(property);
    }

    public Property getProperty(int index)
    {
        return properties.get(index);
    }

    public <T> Fact addProperty(String name, T value)
    {
        Property<T> property = new Property<>(name, value);
        int index = properties.indexOf(property);

        if(index < 0)
        {
            properties.add(property);
        }
        else
        {
            property = properties.get(index);
            property.setValue(value);
        }
        return this;
    }

    public int getNumProperties() {
        return properties.size();
    }
}
