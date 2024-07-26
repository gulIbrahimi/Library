/**
 * Class CD 
 * This class inherits from the resource class. 
 */
public class CD extends Resource {
    /**
     * Instance variables
     */
    // The artist of the CD
    private String artist;

    // The length of the CD
    private int length;

    /**
     * Constructor 
     * @param title
     * @param publisher
     * @param year
     * @param numCopies
     * @param artist
     * @param length
     */
    public CD(String title, String publisher, int year, int numCopies, String artist, int length) {
        // Initialization 
        super(title, publisher, year, false, numCopies);
        this.artist = artist;
        this.length = length;
    }

    /**
     * Returns string representation of the CD class. 
     * 
     * This method overrides the toString method of the parent class. 
     */
    @Override
    public String toString() {
        return artist + ", " + getTitle() + ", " + getYear() + ", " + length;
    }
}