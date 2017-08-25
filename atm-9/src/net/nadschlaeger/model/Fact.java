package net.nadschlaeger.model;

import java.util.ArrayList;
import java.util.List;

public class Fact {

	private String name;

	private List<Property> properties = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

}
