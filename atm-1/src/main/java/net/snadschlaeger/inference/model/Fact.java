package net.snadschlaeger.inference.model;

import java.util.ArrayList;
import java.util.List;

public class Fact extends Model {

	private String name;

	private List<Property> properties;

	public static Fact create(String name) {
		return new Fact(name);
	}

	public Fact(String name) {
		this.name = name;
		this.properties = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public Fact addProperty(Property property) {
		this.properties.add(property);
		return this;
	}

}
