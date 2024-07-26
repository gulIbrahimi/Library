/**
 * Class Book
 * This class inherits from the resource class. 
 */
public class Book extends Resource {
    /**
     * Instance variables
     */
    // The author of the book
    private String author;

    // The number of pages of the book
    private int numPages;

    /**
     * Constructor
     * @param title
     * @param publisher
     * @param year
     * @param electronic
     * @param numCopies
     * @param author
     * @param numPages
     */
    public Book(String title, String publisher, int year, boolean electronic, int numCopies, String author, int numPages) {
        // Initialization
        super(title, publisher, year, electronic, numCopies);
        this.author = author;
        this.numPages = numPages;
    }

    /**
     * Returns string representation of the Book class. 
     * 
     * This method overrides the toString method of the parent class. 
     */
    @Override
    public String toString() {
        return author + ", " + getTitle() + ", " + getYear() + ", " + numPages;
    }
}