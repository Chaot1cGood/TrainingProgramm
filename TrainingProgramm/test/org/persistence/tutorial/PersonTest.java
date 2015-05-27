package org.persistence.tutorial;

import junit.framework.TestCase;

public class PersonTest extends TestCase {

	public void testPerson() {
		Person p = new Person();
		assertEquals("unknown name", p.getName());
		assertEquals(3, p.getMaximumBooks());
		assertEquals(1, p.getMaximumMovies());
	}

	public void testSetMaximumBooks() {
		Person p1 = new Person();
		p1.setMaximumBooks(10);
		assertEquals(10, p1.getMaximumBooks());
	}
	
	public void testSetMaximumMovies() {
		Person p1 = new Person();
		p1.setMaximumMovies(10);
		assertEquals(10, p1.getMaximumMovies());
	}

	public void testSetName() {
		Person p1 = new Person();
		p1.setName("Fred Flintstone");
		assertEquals("Fred Flintstone", p1.getName());
	}
	
	public void testToString() {
		Person p1 = new Person();
		p1.setName("Fred Flintstone");
		p1.setMaximumBooks(7);
		p1.setMaximumMovies(7);
		String testString = "Fred Flintstone (MaximumBooks 7 books, MaximumMovies 7 movies)";
		assertEquals(testString, p1.toString());
	}

}
