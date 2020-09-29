import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * This class uses the csv file and puts it into a array of movies THIS CLASS IS MEANT TO BE USED BY
 * THE TEST ENGINERR AND FRONT END DEV. It should also be it's own separate method.
 * 
 * @author Colin Green
 *
 */
public class CSVMovieReader {
  private static Movie[] myMovies;

  public Movie[] getMovies() {
    return myMovies;
  }

  public static void main(String[] arg) {
    // path where your csv file is located
    String path = "C:\\Users\\cgree\\Documents\\CS400\\IMDb_Top-Rated_Movies_26-50_-_Sheet1.csv\\";
    // string that Bufferedreader uses to go through the file.
    String line = "";
    // Set the variables to default values
    int rank = 0;
    String title = "";
    String leadActor = "";
    LinkedList<String> actors = new LinkedList();
    String director = "";
    double rating = 0;
    // This try catch holds the majority of work for this class. If the file isn't found it will
    // throw exception
    try {
      // create a new buffred reader with specified path
      BufferedReader br = new BufferedReader(new FileReader(path));

      int i = 0;
      // iterate through the contents
      while ((line = br.readLine()) != null) {
        int x = 0;
        // create array and seprate elemenets by commas
        String[] values = line.split(",");
        rank = Integer.parseInt(values[0]);
        title = values[1];
        director = values[2];
        leadActor = values[3];
        actors.add(values[4]);
        actors.add(values[5]);
        actors.add(values[6]);
        rating = Double.parseDouble(values[7]);
        // each iteration should create a new movie object for each line of csv file
        myMovies[i] = new Movie(title, leadActor, actors, director, rank, rating);
        i++;
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
