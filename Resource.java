import java.util.Arrays;

/**
 * Author: Ibrahimi Gul Amiz 
 * 
 * Abstract Class: Resource
 */
public abstract class Resource {
    /**
     * Instance Variables
     */
    // Title of the resources
    private String title;
    
    // Publisher of the resources
    private String publisher;

    // Publish Year of the resources
    private int year;

    // Checks if the resources are available electronically
    private boolean electronic;

    // Checks if there are copies of the resources available for the user
    private int availableCopies;

    // Creates a string array of users that have checked out the resources
    private String[] borrowers;

    /**
     * Constructor
     * 
     * @param title
     * @param publisher
     * @param year
     * @param electronic
     * @param numCopies
     */
    public Resource(String title, String publisher, int year, boolean electronic, int numCopies) {
        // Initialization
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.electronic = electronic;
        this.availableCopies = numCopies;
        this.borrowers = new String[numCopies];
    }

    /**
     * Returns the title of the resources
     * 
     * @return title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the publisher of the resources
     * 
     * @return publisher.
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Returns the publish year of the resources
     * 
     * @return year.
     */
    public int getYear() {
        return year;
    }
    
    /**
     * Returns the borrowers of the resources
     * 
     * @return borrowers
     */
    public String[] getBorrowers() {
        return borrowers;
    }

    /**
     * Returns if the resource is available electronically.
     * 
     * @return electronic.
     */
    public boolean isElectronic() {
        return electronic;
    }

    /**
     * Returns if the resource is available
     * 
     * @return available copies if it exists. 
     */
    public boolean isAvailable() {
        return availableCopies > 0;
    }

    /**
     * Returns if the person the resource is borrowed by
     * 
     * @param person
     * @return an array of borrowers' names. 
     */
    public boolean isBorrowedBy(String person) {
        // Iterate through the borrowers array and check if the borrower is in it
        return Arrays.stream(borrowers).anyMatch(person::equals);
    }

    /**
     * Returns the string representation of the resources title and year of publish
     * 
     * @return title and year. 
     */
    @Override
    public String toString() {
        return title + ", " + year;
    }

    /**
     * Returns if the resource is checked out or not. 
     * 
     * @param borrower
     * @return true or false. 
     */
    public boolean checkOut(String borrower) {
        // Check if the borrower name is provided and not empty 
        if (borrower == null || borrower.isEmpty()) {
            return false;
        }

        // Check if there are available copies
        if (availableCopies == 0) {
            return false;
        }

        // Iterates through the borrowers array
        for (int i = 0; i < borrowers.length; i++) {
            // Check if the index is empty or not
            if (borrowers[i] == null) {
                // If the index is null, it will store the borrower name 
                borrowers[i] = borrower;
                // Reduces the amount of available copies each time it is borrowed
                availableCopies--;
                // Returns true if the resource is checked out
                return true;
            }
        }
        // Returns false if the resource is not checked out
        return false;
    }

    /**
     * Returns if the resource borrowed is checked in the system. 
     * 
     * @param borrower
     * @return true of false. 
     */
    public boolean checkIn(String borrower) {
        // Check if the borrower array is empty or null
        if (borrower == null || borrower.isEmpty()) {
            // Returns false is the array is empty or null
            return false;
        }
        // Iterates through the borrower array
        for (int i = 0; i < borrowers.length; i++) {
            // Checks if the index is null and matches borrower name with the value in the index
            if (borrowers[i]!= null && borrowers[i].equals(borrower)) {
                // Sets the borrower index to null, empties the exact borrower index
                borrowers[i] = null;
                // Increases the available copies 
                availableCopies++;
                // Returns true if the check in is successful
                return true;
            }
        }
        // Returns false is the check in is not successful 
        // Second attempt is suggested!
        return false;
    }
}