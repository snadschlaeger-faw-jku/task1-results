package main.java;

import java.util.ArrayList;
import java.util.List;

import main.java.model.Entity;
import main.java.model.Rule;

public class Storage {

	public static List<Entity> data = new ArrayList<>();
	public static List<Entity> runtimeData = new ArrayList<>();
	
	public static List<Rule> rules = new ArrayList<>();
	
	public static void addData(Object fact) {
		runtimeData.add((Entity) fact);
	}

}
