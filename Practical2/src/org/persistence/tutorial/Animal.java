package org.persistence.tutorial;

public class Animal {
	// fields
	private String name; 
	private String spacies; 
	
	
	// constructors
	public Animal() {
		name = "unknown name";
		spacies = "unknown spacies";
		
	}
	
	public Animal(String name, String spacies) {
		this.name = name;
		this.spacies = spacies;
		
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public void setSpacies(String newSpacies) {
		this.spacies = newSpacies;
	}
	public String getSpacies() {
		return spacies;
	}

	public String getName() {
		return name;
	}
	
	

	
}
