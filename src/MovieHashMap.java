import java.io.*;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MovieHashMap {
    private HashTableMap<String, Movie> hashmap; // The Hash map to store all title-movie pair

    /**
     * Create a Hash Table Map storing the movies
     * @param capacity the desired capacity
     */
    public MovieHashMap(int capacity) {
        hashmap = new HashTableMap<String, Movie>(capacity);
    }

    /**
     * Create a Hash Table Map storing the movies with default capacity of 10;
     */
    public MovieHashMap() {
        hashmap = new HashTableMap<String, Movie>();
    }

    /**
     * Put a movie in the hash table map
     * @param key the title or search key of the movie
     * @param value the movie
     * @return true if successfully putted in
     */
    public boolean put(String key, Movie value){
        return hashmap.put(key, value);
    }

    /**
     * Get a movie from hash table map
     * @param key the title or the search key of the movie
     * @return the desired movie
     * @throws NoSuchElementException when there is no movie matches the key
     */
    public Movie get(String key) throws NoSuchElementException{
        return hashmap.get(key);
    }

    /**
     * Return how many movies stored
     * @return how many movies stored
     */
    public int size(){
        return hashmap.size();
    }

    /**
     * check if one of the movie is included in the table
     * @param key the title of the movie
     * @return true if contains, false otherwise
     */
    public boolean containsKey(String key){
        return hashmap.containsKey(key);
    }

    /**
     * remove a specific movie
     * @param key the name of the movie
     * @return the movie object being removed
     */
    public Movie remove(String key){
        return hashmap.remove(key);
    }

    /**
     * clear the hashmap
     */
    public void clear(){
        hashmap.clear();
    }

    /**
     * import movies from a csv file
     * @param file the file to input
     */
    public void csvRead(File file) {
        String line;
        int rank;
        String title;
        String leadActor;
        LinkedList<String> actors = new LinkedList();
        String director;
        double rating;
        // This try catch holds the majority of work for this class. If the file isn't found it will
        // throw exception
        try {
            // create a new buffred reader with specified path
            BufferedReader br = new BufferedReader(new FileReader(file));
            // iterate through the contents
            while ((line = br.readLine()) != null) {
                // create array and seprate elemenets by commas
                String[] values = line.split(",");
                rank = Integer.parseInt(values[0]);
                title = values[1];
                director = values[2];
                leadActor = values[3];
                actors.clear();
                actors.add(values[4]);
                actors.add(values[5]);
                actors.add(values[6]);
                rating = Double.parseDouble(values[7]);
                // each iteration should create a new movie object for each line of csv file
                this.put (title, new Movie(title, leadActor, actors, director, rank, rating));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
