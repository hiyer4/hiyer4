// --== CS400 File Header Information ==--
// Name: Hari Iyer
// Email: hiyer4@wisc.edu
// Team: BF
// TA: Brianna Cochran
// Lecturer: Gary Dahl
// Notes to grader: I submitted the UI but as it was done in accordance to
// the idea that I had for the project, I could not account for the back end developers code
// as it was given late. I am sorry for the inconvenience. (Stay Safe!)
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class UserInterface {
  private static ArrayList<TeamRedBlackTree> TEAMS;
  
  public static void main(String[] args) {
   File csv = new File("C:\\Users\\hiyer\\eclipse-workspace\\BinarySearchTree\\src\\NBA_Teams_Players.csv");
   System.out.println(csv.exists());
    TEAMS = fileReader(csv); 
    introduction();
  }

  /**
   * This method is the initial interaction with the user where they are prompted to seach for a
   * team
   *
   */
  public static void introduction() {
    Scanner sc = new Scanner(System.in);
    System.out.println("What team would you like to explore?");
    String team = sc.nextLine();
   //private static TeamRedBlackTree <Team> = new TeamRedBlackTree<Team>();
    
    
    Scanner sc2 = new Scanner(System.in);
    System.out.println("Which player would you like to know more about?");
    String player = sc.nextLine();
    playerSearched(player);
    newSearch();
  }

  /**
   * This method handles the situation where a search has been made and the user would like to make
   * another search.
   *
   */
  public static void newSearch() {
    System.out.println("Would you like to make another search? (yes/no)");
    Scanner responceScanner = new Scanner(System.in);
    String responce = responceScanner.nextLine();
    if (responce.equals("yes")) {
      introduction();
    } else if (responce.equals("no")) {
      System.out.println("-Thank you for using the NBA database-");
    } else {
      System.out.println("Invalid entry, try again.");
      newSearch();
    }
  }

  /**
   * Now that a team has been searched this method will go through the file of teams and return
   * the information about the player
   *
   */
  public static void playerSearched(String playerName) {
    Player player;
    try {
     player = TeamRedBlackTree.getPlayer(playerName);
    } catch (NoSuchElementException e) {
      System.out.println("Sorry, no such player exists in the database");
      return;
    }
    String name = player.getName();
    String position = player.getPosition();
    int jerseyNumber = player.getJerseyNum();
    String height = player.getHeight();
    int rating = player.getRating();
    System.out.println("Name- " + name);
    System.out.println("Position- " + position);
    System.out.println("Jersey Number- " + jerseyNumber);
    System.out.println("Height- " + height);
    System.out.println("Rating- " + rating);
  }
  /**
   * import Players from a file
   * @param file the file to input
   * @return 
   */
  public static ArrayList<TeamRedBlackTree> fileReader(File file) {
   String line;
   //String path = "NBA_Teams_Players.csv"; 
   ArrayList<TeamRedBlackTree> teamArr = new ArrayList(); 
   String teamName;
   String name;
   String position;
   int jerseyNum;
   String height;
   int rating;
   try {
     BufferedReader br = new BufferedReader(new FileReader(file));
     while ((line = br.readLine()) != null) {
       String[] inputs = line.split(",");
       teamName = inputs[0]; 
       TeamRedBlackTree TeamTree = new TeamRedBlackTree(teamName); 
     
       
       for(int i=0; i<=25;) {
         name = inputs[i]; 
         position = inputs[i+2];
         jerseyNum = Integer.parseInt(inputs[i+3]);
         height = inputs[i+4];
         rating = Integer.parseInt(inputs[i+5]);
         i = i+5;         
         TeamTree.insert(new Player(name, rating, jerseyNum, height, position));
       }
       teamArr.add(TeamTree); 
     }

   }catch(FileNotFoundException e){
     e.printStackTrace();
   } catch(IOException e) {
     e.printStackTrace();
   }
  return teamArr;
  

}
}