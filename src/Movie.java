// This is the movie object for our Movie Database 


//      hashtable etc.
// 
// Name: Aaron Allen
// Date Started: 9/23/2020
import java.util.LinkedList;

public class Movie {
  private String title;
  private String leadActor;
  private LinkedList<String> actors;
  private int actorsSize;
  private String director;
  private int  rank; 
  private double rating; 
  
  /**
   * A more fully fleshed out constructor for initializing a Movie
   * 
   * @param title of the movie to add
   * @param leadActor of the movie
   * @param actors a LinkedList of Strings of other actor names
   * @param director or the movie
   */
  public Movie(String title, String leadActor, LinkedList<String> actors, String director, int rank, double rating) {
    this.rank = rank; 
    this.rating = rating; 
    this.title = title;
    this.leadActor = leadActor;
    if (actors == null) {
      this.actors = new LinkedList<String>();
      this.actorsSize = 0;
    } else {
      this.actors = actors;
      this.actorsSize = actors.size();
    }
    this.director = director;
  }
  
  /**
   * Default constructor for Movie, fills in fields with blank values
   */
  public Movie() { 
    this.title = "";
    this.leadActor = "";
    this.actors = new LinkedList<String>();
    this.actorsSize = 0;
    this.director = "";
  }
  
  /**
   * Simple getter method
   * 
   * @return title of this Movie
   */
  public String getTitle() {
    return this.title;
  }
  
  /**
   * Simple setter method with extra check to make sure the value is changed.
   * 
   * @param title to set for this Movie
   * @return true if set successfully, false otherwise
   */
  public boolean setTitle(String title) {
    this.title = title;
    if (!this.getTitle().equals(title)) {
      return false;
    } else {
      return true;
    }
  }
  
  /**
   * Simple getter method
   * 
   * @return title of this Movie
   */
  public String getLeadActor() {
    return this.leadActor;
  }
  
  /**
   * Simple setter method with extra check to make sure the value is changed.
   * 
   * @param title to set for this Movie
   * @return true if set successfully, false otherwise
   */
  public boolean setLeadActor(String leadActor) {
    if (leadActor == null) {
      return false;
    }
    
    if (this.leadActor == null) { // increment actorsSize if this is a new addition
      this.actorsSize++;
    }
    
    this.leadActor = leadActor;
    if (!this.getLeadActor().equals(leadActor)) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Simple getter method
   * 
   * @return title of this Movie
   */
  public String getDirector() {
    return this.director;
  }
  
  /**
   * Simple setter method with extra check to make sure the value is changed.
   * 
   * @param title to set for this Movie
   * @return true if set successfully, false otherwise
   */
  public boolean setDirector(String director) {
    if (director == null) {
      return false;
    }
    
    this.director = director;
    if (!this.getTitle().equals(director)) {
      return false;
    } else {
      return true;
    }
  }
  
  /**
   * A boolean method that determines whether a given actor is in this Movie
   * 
   * @param actor to search for in this Movie
   * @return true if actor is in this Movie, false otherwise
   */
  public boolean hasActor(String actor) {
    if (actor == null) {
      return false;
    }
    
    if (this.leadActor.equals(actor)) {
      return true;
    } else if (this.actors.contains(actor)) {
      return true;
    } else {
      return false;
    }
  }
  
  /**
   * Method for adding actors to a Movie
   * 
   * @param actor to add to Movie
   * @return true if successfully added, false otherwise
   */
  public boolean addActor(String actor) {
    if (actor == null) {
      return false;
    }
    
    this.actors.add(actor);
    this.actorsSize++;
    if (this.actors.contains(actor)) {
      return true;
    } else {
      return false;
    }
  }
  
  /**
   * Method for removing actors from the Movie by name
   * 
   * @param actor to remove from the movie
   * @return true if successfully removed, false otherwise.
   */
  public boolean removeActor(String actor) {
    if (actor == null) {
      return false;
    }
    
    if (actor.equals(this.leadActor)) {
      this.leadActor = "";
      this.actorsSize--;
      return true;
    }
    
    if (this.actors.contains(actor)) {
      this.actors.remove(actor);
      this.actorsSize--;
      return true;
    } else {
      System.out.println("Could not remove " + actor + ", was not in this Movie.");
      return false;
    }
  }
  
  /**
   * 
   * @return a LinkedList of actors in this Movie, including the lead actor at the
   *    front of the list
   */
  public LinkedList<String> getActors() {
    LinkedList<String> allActors = this.actors;
    allActors.push(this.leadActor); // pushes leadActor on front of list so they are included
    return allActors;
  }
  
  /**
   * 
   * @return number of actors in this Movie.
   */
  public int getActorsSize() {
    return this.actorsSize;
  }

  
}
