// --== CS400 File Header Information ==--
// Name: Finn Hourigan, Aaron Allen
// Email: fhourigan@wisc.edu, ajallen3@wisc.edu
// Team: BF
// TA: Brianna Cochran
// Lecturer: Gary Dahl\
// Notes to Grader: Ended up working on the same file somewhere along the line,
// thus the two names in the header.

import static org.junit.Assert.fail;
// import java.io.File;
import org.junit.jupiter.api.Test;

/**
 * Test class for TeamRedBlackTree class. Tests functionality of the class and its methods
 */
class TestTeamRedBlackTree {

  /**
   * Tests that the insert method of a TeamRedBlackTree inserts players in the proper order, using
   * the proper insert technique for different cases. As a result, this test also checks the
   * validity of the RBT
   */
  @Test
  void testTeamAdd() {
    Player player1 = new Player("Brook Lopez", 78, 11, "6'10", "C");
    Player player2 = new Player("Eric Bledsoe", 81, 6, "6'3", "PG");
    Player player3 = new Player("Khris Middleton", 86, 22, "6'6", "SF");
    Player player4 = new Player("Wesley Matthews", 78, 9, "6'5", "SG");

    TeamRedBlackTree tree = new TeamRedBlackTree("Milwaukee Bucks");
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
   * This method tests the functionality of the comparePlayer() method in Player.java. Expected
   * comparison uses just the player names to compare one Player object to another. Fails with
   * unexpected comparison
   */
  @Test
  void testComparePlayer() {
    Player player1 = new Player("Brook Lopez", 78, 11, "6'10", "C");
    Player player2 = new Player("Eric Bledsoe", 81, 6, "6'3", "PG");
    Player player3 = new Player("Brook Lopez", 86, 22, "6'6", "SF");

    if (player1.compareTo(player2) == 0) {
      fail("Brook Lopez was compared to Eric Bledsoe and determined to be equal.");
    }

    if (player1.compareTo(player3) != 0) {
      fail("Brook Lopez was compared to Brook Lopez and determined not to be equal.");
    }
  }

  /**
   * This method tests the functionality of the various get methods defined in Player.java.
   */
  @Test
  void testPlayerGetters() {
    Player player1 = new Player("Brook Lopez", 78, 11, "6'10", "C");
    Player player2 = new Player("Eric Bledsoe", 81, 6, "6'3", "PG");
    Player player3 = new Player("Khris Middleton", 86, 22, "6'6", "SF");
    Player player4 = new Player("Wesley Matthews", 78, 9, "6'5", "SG");

    if (player1.getJerseyNum() != 11) { // test getJerseyNum()
      fail("Brook Lopez getJerseyNum() not equal to 11.");
    }

    if (!player2.getHeight().equals("6'3")) { // test getHeight()
      fail("Eric Bledsoe getHeight not equal to \"6'3\".");
    }

    if (player3.getRating() != 86) { // test getRating()
      fail("Khris Middleton getRating not equal to 86.");
    }

    if (!player4.getPosition().equals("SG")) { // test getPosition()
      fail("Wesley Matthews getPosition not equal to SG.");
    }
  }



}
