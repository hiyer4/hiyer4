import java.io.File;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;
//--== CS400 File Header Information ==--
//Name: <Ashutosh Bhalala>
//Email: <bhalala@wisc.edu>
//Team: <your team name: BF>
//TA: <Brianna Cochran>
//Lecturer: <Gary Dahl>
//Notes to Grader: <optional extra notes>
public class UserInterface {
	private static MovieHashMap hashMap = new MovieHashMap(50);

	public static void main(String[] args) {
		File movieList = new File(args[0]);
		hashMap.csvRead(movieList);
		System.out.println("Welcome!");
		introduction();
	}

	/**
	 * This method is the initial interaction with the user where
	 * they are prompted to seach for a movie.
	 *
	 */
	public static void introduction() {
		Scanner sc = new Scanner(System.in);
		System.out.println("What movie would you like to search for?");
		String input = sc.nextLine();
		movieSearched(input);
		newSearch();
	}

	/**
	 * This method handles the situation where a search has been
	 * made and the user would like to make another search.
	 *
	 */
	public static void newSearch() {
		System.out.println("Would you like to make another search? (yes/no)");
		Scanner responceScanner = new Scanner(System.in);
		String responce = responceScanner.nextLine();
		if(responce.equals("yes")) {
			introduction();
		} else if(responce.equals("no")) {
			System.out.println("-Thank you for using Movie Database-");
		} else {
			System.out.println("Invalid entry, try again.");
			newSearch();
		}
	}
	/**
	 * Now that a movie has been searched this method will go through
	 * the file of movies and return the information about the movie
	 * such as the rating and lead actors.
	 *
	 */
	public static void movieSearched(String input) {
		Movie movie;
		try{
			movie = hashMap.get(input);
		}catch(NoSuchElementException e) {
			System.out.println("Sorry, no such movie exists in the database");
			return;
		}
		String movieTitle = movie.getTitle();
		Double movieRating = movie.getRating();
		int movieRank = movie.getRank();
		String movieDirector = movie.getDirector();
		String movieLeadActor = movie.getLeadActor();
		int totalActors = movie.getActorsSize();
		LinkedList<String> allActors = movie.getActors();
		String stringOfActors = "";
		for(int i=0; i<totalActors; i++) {
			stringOfActors = stringOfActors + allActors.get(i) + ", ";
		}
		stringOfActors = stringOfActors.substring(0, stringOfActors.length() - 2);
		System.out.println("Title- " + movieTitle);
		System.out.println("Rating- " + movieRating);
		System.out.println("Rank- " + movieRank);
		System.out.println("Director- " + movieDirector);
		System.out.println("Lead Actor- " + movieLeadActor);
		System.out.println("All of the Actors- " + stringOfActors);
	}
}