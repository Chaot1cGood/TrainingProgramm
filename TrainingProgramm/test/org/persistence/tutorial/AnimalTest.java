package org.persistence.tutorial;

import junit.framework.TestCase;

public class AnimalTest extends TestCase {

	public void testAnimal() {
		Animal a = new Animal();
		assertEquals("unknown name", a.getName());
		assertEquals("unknown spacies", a.getSpacies());
	}
	
	public void testSetName() {
		Animal a1 = new Animal();
		a1.setName("Alex");
		a1.setSpacies("Lion");
		assertEquals("Alex", a1.getName());
		assertEquals("Lion", a1.getSpacies());
	}
	

}
