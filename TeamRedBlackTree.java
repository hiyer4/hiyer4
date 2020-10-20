
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


public class TeamRedBlackTree {
  private static String TEAM_NAME; 
  RedBlackTree<Player> TeamTree = new RedBlackTree<Player>();
  
  public TeamRedBlackTree(String TEAM_NAME) {
    this.TEAM_NAME = TEAM_NAME; 
    
    
  }


    /**
     * Performs a naive insertion into a binary search tree: adding the input data
     * value to a new node in a leaf position within the tree. This tree will not
     * hold null references, nor duplicate data values.
     * 
     * @param data - to be added into this binary search tree
     * @throws NullPointerException - when the provided data argument is null
     * @throws IllegalArgumentException - when the tree already contains data
     */
    public void insert(Player data) throws NullPointerException, IllegalArgumentException {
      
      
      TeamTree.insert(data);
    }
    /**
     * This method performs a level order traversal of the tree. The string
     * representations of each data value within this tree are assembled into a
     * comma separated string within brackets (similar to many implementations of
     * java.util.Collection, like java.util.ArrayList, LinkedList, etc).
     * 
     * @return string containing the values of this tree in level order
     */
    public String toString() {
      return TeamTree.toString();
    }



//    /**
//     * import Players from a file
//     * @param file the file to input
//     */
//    public void fileReader(File file) {
//     String line;
//     
//     String teamName;
//     String name;
//     String position;
//     int jerseyNum;
//     String height;
//     int rating;
//     try {
//       BufferedReader br = new BufferedReader(new FileReader(file));
//       while ((line = br.readLine()) != null) {
//         String[] inputs = line.split(",");
//         teamName = inputs[0]; 
//         TeamRedBlackTree TeamTree = new TeamRedBlackTree(teamName); 
//       
//         
//         for(int i=0; i<=25;) {
//           name = inputs[i+1];
//           position = inputs[i+2];
//           jerseyNum = Integer.parseInt(inputs[i+3]);
//           height = inputs[i+4];
//           rating = Integer.parseInt(inputs[i+5]);
//           i = i+5;
//           
//
//           this.insert(new Player(name, rating, jerseyNum, height, position));
//         }
//       }
//       
//
//     }catch(FileNotFoundException e){
//       e.printStackTrace();
//     } catch(IOException e) {
//       e.printStackTrace();
//     }
//    
//
//}

    public static Player getPlayer(String  playerName) {
      
      return null;
    }

}


