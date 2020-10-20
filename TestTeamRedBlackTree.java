// --== CS400 File Header Information ==--
// Name: Finn Hourigan
// Email: fhourigan@wisc.edu
// Team: BF
// TA: Brianna Cochran
// Lecturer: Gary Dahl

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;

/**
 * Test class for TeamRedBlackTree class. Tests functionality of the class and its methods
 */
class TestTeamRedBlackTree {

  /**
   * Tests that the insert method of a TeamRedBlackTree inserts players in the proper order, using
   * the proper insert technique for different cases
   */
  @Test
  void testTeamAdd() {
    Player player1 = new Player("Brook Lopez", 78, 11, "6'10", "C");
    Player player2 = new Player("Eric Bledsoe", 81, 6, "6'3", "PG");
    Player player3 = new Player("Khris Middleton", 86, 22, "6'6", "SF");
    Player player4 = new Player("Wesley Matthews", 78, 9, "6'5", "SG");

    TeamRedBlackTree tree = new TeamRedBlackTree();
    tree.insert(player3);
    tree.insert(player2);
    tree.insert(player4);
    tree.insert(player1);

    if (!tree.toString().equals(
        "[Wesley Matthews(9): SG, 6'5, Rating: 78, Eric Bledsoe(6): PG, 6'3, Rating: 81, Khris Middleton(22): SF, 6'6, Rating: 86, Brook Lopez(11): C, 6'10, Rating: 78]")) {
      fail("Players not inserted in proper order.");
    }
  }

  
  /**
   * This test makes sure that there are no errors in the fileReader method of the TeamRedBlackTree
   * class, and it makes sure that the CSV file is uploaded properly.
   */
  @Test
  void testFileReader() {
    TeamRedBlackTree tree = new TeamRedBlackTree("Test Tree");
    String path = "C:\\Users\\finnh\\Documents\\Eclipse\\CS400Project2\\src\\NBA_Teams_Players.csv";
    File file = new File(path);
    tree.fileReader(file);
    if (!file.exists()) {
      fail("File not read properly.");
    }
  }

  /**
   * This method tests the functionality of the getPlayer() method in TeamRedBlackTree. Fails when
   * player data is not retrieved properly
   */
  @Test
  void testPlayerRetrieval() {
    Player player1 = new Player("Brook Lopez", 78, 11, "6'10", "C");
    Player player2 = new Player("Eric Bledsoe", 81, 6, "6'3", "PG");
    Player player3 = new Player("Khris Middleton", 86, 22, "6'6", "SF");
    Player player4 = new Player("Wesley Matthews", 78, 9, "6'5", "SG");

    TeamRedBlackTree tree = new TeamRedBlackTree("Milwaukee Bucks");
    tree.insert(player3);
    tree.insert(player2);
    tree.insert(player4);
    tree.insert(player1);

    if (tree.getPlayer("Brook Lopez").compareTo(player1) != 0) {
      fail("Failed to get player correctly.");
    }
  }



}
