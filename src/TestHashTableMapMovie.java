import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

//--== CS400 File Header Information ==--
//Name: <Hari Iyer>
//Email: <hiyer4@wisc.edu>
//Team: <your team name: BF>
//TA: <Brianna Cochran>
//Lecturer: <Gary Dahl>
//Notes to Grader: <Stay Safe!>

public class TestHashTableMapMovie {

  public static Movie[] getMovies() {
    Movie[] myMovies = new Movie[50];

    String path = "C:\\Users\\cgree\\Documents\\CS400\\IMDb_Top-Rated_Movies_26-50_-_Sheet1.csv\\";
    String title, leadActor, director, line = "";
    LinkedList<String> actors = new LinkedList();
    double rating = 0;
    int rank = 0;


    try {
      BufferedReader br = new BufferedReader(new FileReader(path));

      int i = 0;
      while ((line = br.readLine()) != null) {
        int x = 0;
        String[] values = line.split(",");
        rank = Integer.parseInt(values[0]);
        title = values[1];
        director = values[2];
        leadActor = values[3];
        actors.add(values[4]);
        actors.add(values[5]);
        actors.add(values[6]);
        rating = Double.parseDouble(values[7]);

        myMovies[i] = new Movie(title, leadActor, actors, director, rank, rating);
        i++;
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return myMovies;

  }

  public static boolean testPut() {

    MovieHashMap HT1 = new MovieHashMap();

    Movie[] arrMovies = getMovies();
    HT1.put("The Shawshank Redemption", arrMovies[0]);
    if (!(HT1.get("The Shawshank Redemption").equals(arrMovies[0]))) {
      return false;
    }

    HT1.put("The Lion King", arrMovies[33]);
    if (!(HT1.get("The Lion King").equals(arrMovies[33]))) {
      return false;
    }
    HT1.put("Parasite", arrMovies[28]);
    if (!(HT1.get("Parasite").equals(arrMovies[28]))) {
      return false;
    }

    if (HT1.size() != 3) {
      return false;
    }
    HT1.put("Star Wars: Episode IV - A New Hope", arrMovies[24]);
    if (!(HT1.get("Star Wars: Episode IV - A New Hope").equals(arrMovies[24]))) {
      return false;
    }
    HT1.put("Saving Private Ryan", arrMovies[25]);
    if (!(HT1.get("Saving Private Ryan").equals(arrMovies[25]))) {
      return false;
    }
    HT1.put("Spirited Away", arrMovies[26]);
    if (!(HT1.get("Spirited Away").equals(arrMovies[26]))) {
      return false;
    }
    HT1.put("The Green Mile", arrMovies[27]);
    if (!(HT1.get("The Green Mile").equals(arrMovies[27]))) {
      return false;
    }
    HT1.put("Parasite", arrMovies[28]);
    if (!(HT1.get("Parasite").equals(arrMovies[28]))) {
      return false;
    }
   
    HT1.put("Interstellar", arrMovies[29]);
    if (!(HT1.get("Interstellar").equals(arrMovies[29]))) {
      return false;
    }
    // // test expansion
    if (HT1.capacity() != 20) {
      return false;
    }

    return true;
  }

  public static boolean testGet() {
    // Case 2: test put method with
    MovieHashMap HT1 = new MovieHashMap();
    Movie[] arrMovies = getMovies();

    // HT1.put(, arrMovies[0]);
    HT1.put("Star Wars: Episode IV - A New Hope", arrMovies[24]);
    if (!(HT1.get("Star Wars: Episode IV - A New Hope").equals(arrMovies[24]))) {
      return false;
    }
    HT1.put("Saving Private Ryan", arrMovies[25]);
    if (!(HT1.get("Saving Private Ryan").equals(arrMovies[25]))) {
      return false;
    }
    HT1.put("Spirited Away", arrMovies[26]);
    if (!(HT1.get("Spirited Away").equals(arrMovies[26]))) {
      return false;
    }
    HT1.put("The Green Mile", arrMovies[27]);
    if (!(HT1.get("The Green Mile").equals(arrMovies[27]))) {
      return false;
    }
    HT1.put("Parasite", arrMovies[28]);
    if (!(HT1.get("Parasite").equals(arrMovies[28]))) {
      return false;
    }
   
    HT1.put("Interstellar", arrMovies[29]);
    if (!(HT1.get("Interstellar").equals(arrMovies[29]))) {
      return false;
    }
    try {
      HT1.get("djdkjdkdjkd");
    } catch (Exception NoSuchElementException) {
      // System.out.println("Case 2: Passed");
      return true;
    }

    return false;
  }

  public static boolean testRemove() {
    MovieHashMap HT1 = new MovieHashMap();
    Movie[] arrMovies = getMovies();

    HT1.put("Star Wars: Episode IV - A New Hope", arrMovies[24]);
 
    HT1.put("Saving Private Ryan", arrMovies[25]);
  
    HT1.put("Spirited Away", arrMovies[26]);
  
    HT1.put("The Green Mile", arrMovies[27]);
   
    HT1.put("Parasite", arrMovies[28]);
   
    HT1.put("Interstellar", arrMovies[29]);
 



    if (HT1.remove("Interstellar").equals(arrMovies[29])) {
    }
    try {
      if (HT1.get("Interstellar") == null) {
      }
    } catch (Exception NoSuchElementException) {

    }
    if (HT1.remove("Interstellar") == null) {
      return true;
    }

    return false;
  }

  public static boolean testHashCollisions() {
    MovieHashMap HT1 = new MovieHashMap();
    Movie[] arrMovies = getMovies();
    try{
    HT1.put("Parasite", arrMovies[28]);
    HT1.put("Interstellar", arrMovies[29]);
        if (HT1.size() != 2) {
         return false;   
        }
    HT1.put("Parasite", arrMovies[29]);
    HT1.put("Interstellar", arrMovies[30]);
        if(HT1.size()!=2){
            System.out.println("Test failed, issue with adding keys with same key value");
            return false;
        }
        return true;
    }
      catch (Exception NoSuchElementException) {
      return true;
    }

    return false;
  }



  public static void main(String[] args) {

    if (testPut()) {
      System.out.println("testPut Passed");

    } else {
      System.out.println("testPut Failed");
    }
     if (testGet()) {
     System.out.println("testGet Passed");
     } else {
     System.out.println("testGet Failed");
     }
     if (testRemove()) {
     System.out.println("testRemove Passed");
     } else {
     System.out.println("testRemove Failed");
     }
     if (testHashCollisions()) {
     System.out.println("testHashCollisions Passed");
     } else {
     System.out.println("testHashCollisions Failed");
     }



  }



}
