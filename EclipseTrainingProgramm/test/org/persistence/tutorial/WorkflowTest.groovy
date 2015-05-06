package org.persistence.tutorial

import spock.lang.Specification;
import spock.lang.Unroll;

class WorkflowTest extends Specification{
	
	def mml
	def m1
	def m2
	def m3
	def m4
	def m5
	def p1
	def p2
	def p3
	def ml
	def b1
	def b2
	def b3
	def b4
		
	def "Test for all workflow"() {
	
		given:"An empty library, 5 movies and 3 people (Fred, Sue and Ron)"
			mml = new MyMovieLibrary("Library of movies")
			m1 = new Movie("Movie1","Genre1")
			m2 = new Movie("Movie2","Genre2")
			m3 = new Movie("Movie3","Genre3")
			m4 = new Movie("Movie4","Genre4")
			m5 = new Movie("Movie5","Genre5")
			p1 = new Person()
			p1.setName("Fred")
			p2 = new Person()
			p2.setName("Sue")
			p3 = new Person()
			p3.setName("Ron")
		when:"The 5 movies and 3 people are added to the library"
			mml.addMovie(m1)
			mml.addMovie(m2)
			mml.addMovie(m3)
			mml.addMovie(m4)
			mml.addMovie(m5)
			mml.addPerson(p1)
			mml.addPerson(p2)
			mml.addPerson(p3)
		then:"There are 5 movies and 3 people in the library"
			mml.getMovies().size() == 5
			mml.getPeople().size() == 3
		and:"The people's names are Fred, Sue, Ron; The titles of movies are 'Movie1'...'Movie5'; The genres of movies are 'Genre1'...'Genre5'"
			mml.getPeople().get(0).getName()== "Fred"
			mml.getPeople().get(1).getName()=="Sue"
			mml.getPeople().get(2).getName() == "Ron"
			mml.getMovies().get(0).getTitle() == "Movie1"
			mml.getMovies().get(4).getGenre() == "Genre5"
			
		when:"The 2 movies and the person are removed from the library"
			mml.removeMovie(m1)
			mml.removeMovie(m5)
			mml.removePerson(p1)
		then:"There are 3 movies and 2 people in the library"
			mml.getMovies().size() == 3
			mml.getPeople().size() == 2
		when:"The 2 movies and the person are added to the library"
			mml.addMovie(m1)
			mml.addMovie(m5)
			mml.addPerson(p1)
		then:"There are 5 movies and 3 people in the library"
			mml.getMovies().size() == 5
			mml.getPeople().size() == 3
		when:"Director1 is set to 'Movie1'"
			m1.setDirector("Director1")
		then:"'Movie1' is directed by Director1"
			m1.getDirector() == "Director1"
	
		when: "'Movie1' is set to Sue"
			m1.setPerson(p2)
			def whoHasTheMovie = m1.getPerson().getName()
		then: "Sue has the movie checked out"
			 whoHasTheMovie == "Sue"
						
		when: "'Movie5' is checked out to Ron"
			mml.checkOut(m5,p3)
		then: "Ron has the movie checked out"
			m5.getPerson().getName() == "Ron"
		when:"'Movie5' is checked in"
			mml.checkIn(m5)
		then: "'Movie5' is available"
			m5.getPerson() == null
			
		when:"Save the library to XML file and then get it back like 'New library'"
			MyMovieUtilities.saveMyMovieLibraryToXMLFile("library.xml", mml)
			def newLibrary = MyMovieUtilities.getMyMovieLibraryFromXMLFile("library.xml")
		then:"'New library' is copy of 'Library of movies' library"
			newLibrary.getName() == "Library of movies"
			newLibrary.getMovies().size() == 5
			newLibrary.getPeople().size() == 3
	
		when:"The movies are set to Silvia Nelson, Ann Stuart, Robin directors"
			m1.setDirector("Silvia Nelson")
			m2.setDirector("Ann Stuart")
			m3.setDirector("Robin")
		then:"The movies are directed by Silvia Nelson, Ann Stuart, Robin"
			m1.getDirector() == "Silvia Nelson"
			m2.getDirector() == "Ann Stuart"
			m3.getDirector() == "Robin"
		and: "User can perform searches in the library with two strings"
			MyMovieTestHarness.searchLibrary(mml, "Movie2", "Genre3").size() == 0
			MyMovieTestHarness.searchLibrary(mml, "Movie3", "Robin").size() == 1
		
		when:"User creates a book library"
			ml = new MyLibrary("Library of books")
			b1 = new Book("Book1")
			b2 = new Book("Book2")
			b3 = new Book("Book3")
			b4 = new Book("Book4")
			p1 = new Person()
			p1.setName("Fred")
			p2 = new Person()
			p2.setName("Sue")
			p3 = new Person()
			p3.setName("Ron")
		then:"There is an empty book library"
			ml.getBooks().size() == 0
			ml.getPeople().size() == 0
		when:"4 books and 3 people are added to the library"
			ml.addBook(b1)
			ml.addBook(b2)
			ml.addBook(b3)
			ml.addBook(b4)
			ml.addPerson(p1)
			ml.addPerson(p2)
			ml.addPerson(p3)
		then:"There are 4 books and 3 people in the library"
			ml.getBooks().size() == 4
			ml.getPeople().size() == 3
		and:"The people's names are Fred, Sue, Ron; The titles of books are 'Book1'...'Book5'"
			ml.getPeople().get(0).getName() == "Fred"
			ml.getPeople().get(1).getName() == "Sue"
			ml.getPeople().get(2).getName() == "Ron"
			ml.getBooks().get(0).getTitle() == "Book1"
			ml.getBooks().get(3).getTitle() == "Book4"
		when:"The 2 books and the person are removed from the library"
			ml.removeBook(b1)
			ml.removeBook(b4)
			ml.removePerson(p1)
		then:"There are 2 books and 2 people in the library"
			ml.getBooks().size() == 2
			ml.getPeople().size() == 2
		when:"The 2 books and the person are added to the library"
			ml.addBook(b1)
			ml.addBook(b4)
			ml.addPerson(p1)
		then:"There are 4 books and 3 people in the library"
			ml.getBooks().size() == 4
			ml.getPeople().size() == 3
		when:"Author1 is set to 'Book1'"
			b1.setAuthor("Author1")
		then:"'Book1' is writed by Author1"
			b1.getAuthor() == "Author1"

		when: "'Book1' is set to Sue"
			b1.setPerson(p2)
			def whoHasTheBook = b1.getPerson().getName()
		then: "Sue has the book checked out"
			 whoHasTheBook == "Sue"
	
		when: "'Book4' is checked out to Ron"
			ml.checkOut(b4,p3)
		then: "Ron has the book checked out"
			b4.getPerson().getName() == "Ron"
		when:"'Book4' is checked in"
			ml.checkIn(b4)
		then: "'Book4' is available"
			b4.getPerson() == null
		
		when:"Save the library to XML file and then get it back like 'New library'"
			MyUtilities.saveMyLibraryToXMLFile("library.xml", ml)
			def newBookLibrary = MyUtilities.getMyLibraryFromXMLFile("library.xml")
		then:"'New library' is copy of 'Library of books' library"
			newBookLibrary.getName() == "Library of books"
			newBookLibrary.getBooks().size() == 4
			newBookLibrary.getPeople().size() == 3
	
		when: "The books are set to Lora, Katy, Lora authors"
			b1.setAuthor("Lora")
			b2.setAuthor("Katy")
			b3.setAuthor("Lora")
		then:"The books are written by Lora, Katy, Lora authors"
			b1.getAuthor() == "Lora"
			b2.getAuthor() == "Katy"
			b3.getAuthor() == "Lora"
		and: "User can search for author or title with one text strings"
			MyMovieTestHarness.searchBookLibrary(ml, "Lora").size() == 2
			MyMovieTestHarness.searchBookLibrary(ml, "Book5").size() == 0
	}	
}

