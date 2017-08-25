package net.nadschlaeger.model;

import java.util.ArrayList;
import java.util.List;

public class Fact {

	private final String name;
	private List<Property> properties = new ArrayList<>();

	public Fact(String name, List<Property> properties) {
		super();
		this.name = name;
		this.properties = properties;
	}

	public String getName() {
		return name;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public int getPropertiesCount() {
		return properties.size();
	}

	@Override
	public String toString() {
		return "Fact [name=" + name + ", properties=" + properties + "]";
	}

}
