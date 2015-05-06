package org.persistence.tutorial;

/**
 * @author Mark Dexter
 * @version 1.0
 * The Person class represents people who
 * check out books from a MyLibrary.
 *
 */
public class Person {
	// fields
	private String name; // person's name
	private int maximumBooks; // # books can check out
	private int maximumMovies;// ...movies
	
	// constructors
	public Person() {
		name = "unknown name";
		maximumBooks = 3;
		maximumMovies = 1;
	}
	
	public Person(String name, int maximumBooks, int maximumMovies) {
		super();
		this.name = name;
		this.maximumBooks = maximumBooks;
		this.maximumMovies = maximumMovies;
	}
	
	public int getMaximumBooks() {
		return maximumBooks;
	}
	
	public int getMaximumMovies() {
		return maximumMovies;
	}

	// methods
	public String getName() {
		return name;
	}

	public void setMaximumBooks(int maximumBooks) {
		this.maximumBooks = maximumBooks;
	}
	
	public void setMaximumMovies(int maximumMovies) {
		this.maximumMovies = maximumMovies;
	}

	public void setName(String newName) {
		this.name = newName;
	}
	
	public String toString() {
		return this.getName() + " (MaximumBooks " + this.getMaximumBooks()
		+ " books, " + "MaximumMovies " + this.getMaximumMovies()
		+ " movies)";
	}
	
	
	
	
	

}
