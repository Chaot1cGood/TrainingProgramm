package org.persistence.tutorial;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.*;

public class MyMovieUtilitiesTest {

	@Test
	public void saveStringToFile() {
		String saveString = "this is test line one\n" +
	"this is test line two\n";
		
		File testFile = new File("testsavetostring.txt");
		testFile.delete();
		assertFalse("File should not exist",
				testFile.exists());
		
		assertTrue("File should have been saved",
				MyUtilities.saveStringToFile("testsavestring.txt",
						saveString));
		
		String newString = MyMovieUtilities.getStringFromFile(
				"testsavestring.txt");
		assertTrue("Save and get strings should be equal",
				saveString.equals(newString));
		
		assertFalse("File should not be saved",
				MyMovieUtilities.saveStringToFile(
						"non-existent directory/thisshouldfail.txt",
						saveString));
		
		String emptyString = MyMovieUtilities.getStringFromFile(
				"badfilename.txt");
		assertTrue("String should be empty",
				emptyString.length() == 0);
		
		
	}
	
	public MyMovieLibrary createMyMovieLibrary() {
		Movie m1;
		Movie m2;
		Person p1;
		Person p2;
		MyMovieLibrary mml;
		
		m1 = new Movie("Movie1", "Genre1");
		m2 = new Movie("Movie2", "Genre2");
		
		p1 = new Person();
		p1.setName("Fred");
		p2 = new Person();
		p2.setName("Sue");
		
		mml = new MyMovieLibrary("Test");
		
		mml.addMovie(m1);
		mml.addMovie(m2);
		mml.addPerson(p1);
		mml.addPerson(p2);
		mml.checkOut(m1, p1);
		return mml;
	}
	
	@Test public void convertToXML() {
		MyMovieLibrary startMyMovieLibrary = createMyMovieLibrary();
		String testXMLOut = MyMovieUtilities.convertToXML(startMyMovieLibrary);
		MyMovieLibrary endMyMovieLibrary = 
				MyMovieUtilities.convertFromXML(testXMLOut);
		assertEquals("Test", endMyMovieLibrary.getName());
		assertEquals(2, endMyMovieLibrary.getMovies().size());
		assertEquals(2, endMyMovieLibrary.getPeople().size());
		assertEquals("Fred", endMyMovieLibrary.getMovies().
				get(0).getPerson().getName());
	}
	
	@Test public void saveToXMLFile() {
		MyMovieLibrary startMyMovieLibrary = createMyMovieLibrary();
		String fileName = "testmymovielibrary.xml";
		File testFile = new File(fileName);
		testFile.delete();
		assertFalse("File should not exist",
				testFile.exists());
		assertTrue("File should have been saved",
				MyMovieUtilities.saveMyMovieLibraryToXMLFile(
						fileName, startMyMovieLibrary));
		MyMovieLibrary endMyMovieLibrary = 
				MyMovieUtilities.getMyMovieLibraryFromXMLFile(fileName);
		assertEquals("Test", endMyMovieLibrary.getName());
		assertEquals(2, endMyMovieLibrary.getMovies().size());
		assertEquals(2, endMyMovieLibrary.getPeople().size());
		assertEquals("Fred", endMyMovieLibrary.getMovies().
				get(0).getPerson().getName());
	}

}
