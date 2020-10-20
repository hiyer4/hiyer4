public class Player implements Comparable<Player> {
    private final String[] NAME;
    private String position;
    private int jerseyNum;
    private String height;
    private int rating;

    /**
     * Constructor of Player class
     *
     * @param name      the name of the player, must be of the form "FirstName LastName"
     * @param rating    the rating of the player
     * @param jerseyNum the jersey number of the player
     * @param height    the height of the player
     * @param position  the position of the player
     */
    public Player(String name, int rating, int jerseyNum, String height, String position) {
        this.NAME = name.split(" ");
        if(this.NAME.length != 2)
            throw new IllegalArgumentException("Name must be of the form \"FirstName LastName\"");
        this.rating = rating;
        this.jerseyNum = jerseyNum;
        this.height = height;
        this.position = position;
    }

    /**
     * Compare this player to another specified player based on lexicographic order of last name then
     * first name.
     *
     * @param o the player to compare
     * @return a negative integer, zero, or a positive integer as this player's name is less than,
     *         equal to, or greater than the specified player.
     */
    @Override
    public int compareTo(Player o) {
        if (this.NAME[1].compareTo(o.NAME[1]) != 0) return this.NAME[1].compareTo(o.NAME[1]);
        return this.NAME[0].compareTo(o.NAME[0]);
    }

    /**
     * A String representation of a player in the form of name(jerseyNum): position, height, rating
     *
     * @return A String representation of a player
     */
    @Override
    public String toString() {
        return this.getName() + "(" + this.jerseyNum + ")" + ": " + this.position + ", " + this.height
                + ", Rating: " + this.rating;
    }

    /**
     * Get the name of the player
     *
     * @return the name of the player
     */
    public String getName() {
        return this.NAME[0] + " " + this.NAME[1];
    }

    /**
     * Get the position of the player
     *
     * @return the position of the player
     */
    public String getPosition() {
        return this.position;
    }

    /**
     * Get the Jersey Number of the player
     *
     * @return the Jersey Number of the player
     */
    public int getJerseyNum() {
        return this.jerseyNum;
    }

    /**
     * Get the height of the player
     *
     * @return the height of the player
     */
    public String getHeight() {
        return this.height;
    }

    /**
     * Get the rating of the player
     *
     * @return the rating of the player
     */
    public int getRating() {
        return this.rating;
    }
}
