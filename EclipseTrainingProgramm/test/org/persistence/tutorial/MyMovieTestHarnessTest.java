package org.persistence.tutorial;

import static org.junit.Assert.*;

import org.junit.Test;


public class MyMovieTestHarnessTest {

	@Test
	public void oneSearchString() {
		MyMovieLibrary mml = MyMovieUtilities.getMyMovieLibraryFromXMLFile("cnxmovielibrary.xml");
		
		assertEquals(60, MyMovieTestHarness.searchLibrary(mml, "drama").size());
		
	}
	
	@Test
	public void twoSearchStrings() {
		MyMovieLibrary mml = MyMovieUtilities.getMyMovieLibraryFromXMLFile("cnxmovielibrary.xml");
		
		assertEquals(1, MyMovieTestHarness.searchLibrary(mml, "drama", "Taxi Driver").size());
		
	}

}


