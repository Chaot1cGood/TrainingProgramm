package org.persistence.tutorial

import java.io.File;

import spock.lang.*

class MyMovieUtilitiesSpec extends Specification{
	
	def createMyMovieLibrary() {
		def m1
		def m2
		def p1
		def p2
		def mml
		
		m1 = new Movie("Movie1", "Genre1")
		m2 = new Movie("Movie2", "Genre2")
		
		p1 = new Person()
		p1.setName("Fred")
		p2 = new Person()
		p2.setName("Sue")
		
		mml = new MyMovieLibrary("Test")
		
		mml.addMovie(m1)
		mml.addMovie(m2)
		mml.addPerson(p1)
		mml.addPerson(p2)
		mml.checkOut(m1, p1)
		return mml
	}
	
	def saveStringToFile() {
		given:"Some string1 and txt file"
			def saveString = "this is test line one\n" + "this is test line two\n"
			def testFile = new File("testsavetostring.txt")
		when:"The file deleted"
			testFile.delete()
		then:"The deleted file doesn't exist"
			!testFile.exists()
		when:"Save string1 to file and get it from file to new string"	
			MyUtilities.saveStringToFile("testsavestring.txt", saveString)
			def newString = MyMovieUtilities.getStringFromFile("testsavestring.txt")
		then:"New string is copy of string1"
			saveString == newString
		and: "You can't save the string to a directory that doesn't exist"
			!MyMovieUtilities.saveStringToFile("non-existent directory/thisshouldfail.txt",saveString)  
		when:"Get string from unexists file to string2"	
			def emptyString = MyMovieUtilities.getStringFromFile("badfilename.txt")
		then:"String2 is empty"	
			emptyString.length() == 0
	}
	
	def "Convert file to/from XML"(){
		given:"A Library with 2 people and 2 movies. The name of library is 'Test'"
			def startLibrary = createMyMovieLibrary()
		when:"The library is converted to xml and then converted back"
			def testXML = MyMovieUtilities.convertToXML(startLibrary)
			def endLibrary = MyMovieUtilities.convertFromXML(testXML)
		then:"The library converted from xml consists of 2 movies, 2 people and has name 'Test'"
			endLibrary.getName() == "Test"
			endLibrary.getMovies().size() == 2
			endLibrary.getPeople().size() == 2
			endLibrary.getMovies().get(0).getPerson().getName() == "Fred"
	}
	
	def "Save/get library to/from XML file"(){
		given:"A Library with 2 people and 2 movies. The name of library is 'Test'"
			def library = createMyMovieLibrary()
		when:"Save the library to XML file and get it from XML file back"
			MyMovieUtilities.saveMyMovieLibraryToXMLFile("library.xml", library)
			def endLibrary = MyMovieUtilities.getMyMovieLibraryFromXMLFile("library.xml")
		then:"The library that geted from xml consists of 2 movies, 2 people and has name 'Test'"
			endLibrary.getName() == "Test"
			endLibrary.getMovies().size() == 2
			endLibrary.getPeople().size() == 2
			endLibrary.getMovies().get(0).getPerson().getName() == "Fred"
	}
	
	
}