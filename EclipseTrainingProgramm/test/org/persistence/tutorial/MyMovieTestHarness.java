package org.persistence.tutorial;

import java.util.ArrayList;

import org.persistence.tutorial.Movie;
import org.persistence.tutorial.MyMovieLibrary;

public class MyMovieTestHarness {
	public static ArrayList<Movie> searchLibrary(MyMovieLibrary mml, String term1, String term2) {
		ArrayList<Movie> firstPass = new ArrayList<Movie>();
		ArrayList<Movie> result = new ArrayList<Movie>();
		for (Movie aMovie : mml.getMovies()) {
			if (aMovie.getDirector().equals(term1) || aMovie.getTitle().equals(term1) || aMovie.getGenre().equals(term1) ) {
				firstPass.add(aMovie);
			}	
		}
		if (firstPass.size() > 0) {
			for (Movie aMovie : firstPass) {
				if (aMovie.getDirector().equals(term2) || aMovie.getTitle().equals(term2) || aMovie.getGenre().equals(term2) ) {
					result.add(aMovie);
				}	
			}	
		}
		else {
			return result;
		}
		return result;
	}
	
	public static ArrayList<Movie> searchLibrary(MyMovieLibrary mml, String term) {
		ArrayList<Movie> result = new ArrayList<Movie>();
		for (Movie aMovie : mml.getMovies()) {
			if (aMovie.getDirector().equals(term) || aMovie.getTitle().equals(term) || aMovie.getGenre().equals(term) ) {
				result.add(aMovie);
			}	
		}
		return result;
	}
	
	public static ArrayList<Book> searchBookLibrary(MyLibrary ml, String term) {
		ArrayList<Book> result = new ArrayList<Book>();
		for (Book aBook : ml.getBooks()) {
			if (aBook.getAuthor().equals(term) || aBook.getTitle().equals(term)) {
				result.add(aBook);
			}	
		}
		return result;
	}
}
