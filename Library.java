import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class Library: to store the resources
 */
public class Library {
    /**
     * Instance variables
     */
    // Creates an array to store the resources
    private Resource[] resources;

    // The number of resources in the library
    private int numResources;

    /**
     * Constructor
     * @param numResources
     */
    public Library(int numResources) {
        // Initialization
        this.resources = new Resource[numResources];
        // Initializing the number of resources to zero
        this.numResources = 0;
    }

    /**
     * Returns if the resources if added or not. 
     * 
     * @param r
     * @return true or false. 
     */
    public boolean addResource(Resource r) {
        // Iterates through all the resources 
        for (int i = 0; i < resources.length; i++) {
            // Checks if the index is empty, adds the resource and return true
            if (resources[i] == null) {
                // Stores the new resource in the index
                resources[i] = r;
                // Returns true if the resource is successfully added
                return true;
            }
        }
        // If the array is full, returns false
        return false;
    }

    /**
     * Returns an array of all the resources
     * 
     * @return an array of the number of resources listed. 
     */
    public Resource[] getAllResources() {
        // Returns a copy of the resources array up to the numResources limit
        return Arrays.copyOf(resources, numResources);
    }

    /**
     * Returns a list of unavailable resources
     * 
     * @return an array of unvailable resources.
     */
    public Resource[] getUnavailable() {
        // Creates a new arrayList to store the resources that are not available and have been checked out
        List<Resource> unavailable = new ArrayList<>();
        // Iterates through each element in the resource list
        for (Resource r : resources) {
            // Checks if the index of the element is null or notAvailable
            if (r != null && !r.isAvailable()) {
                // Adds it to the list 
                unavailable.add(r);
            }
        }
        // Returns conversion of the arrayList to resource list
        return unavailable.toArray(new Resource[0]);
    }

    /**
     * Returns a list of the users that have checked a resource out
     * 
     * @param user
     * @return an array of people that have checked the resources out. 
     */
    public Resource[] getAllUserHasCheckedOut(String user) {
        // Creates an array of all the resources checked by the user
        List<Resource> checkedOut = new ArrayList<>();
        // Iterates through each element in the resource list
        for (Resource r : resources) {
            // Checks if the element is null and has been borrowed 
            if (r != null && r.getBorrowers() != null) {
                // Checks if the user in the borrowers' array
                if(Arrays.asList(r.getBorrowers()).contains(user)) {
                    // If the borrower matches the list, adds the resources to the checkOut list
                    checkedOut.add(r);
                }
            }
        }
        // Returns the conversion of the checkedOut resource list to an array
        return checkedOut.toArray(new Resource[0]);
    }

    /**
     * Returns the total of all the books in the library
     * 
     * @return an array of all the books. 
     */
    public Resource[] getAllBooks() {
        // Creates a list to store the books
        List<Resource> books = new ArrayList<>();
        // Iterates through each element in the resources list
        for (Resource r : resources) {
            // Checks if the element is null and is an instance of the Book class
            if (r != null && r instanceof Book) {
                // If it is, it is added to the array of books
                books.add(r);
            }
        }
        // Returns the conversion of the resources list to an array
        return books.toArray(new Resource[0]);
    }

    /**
     * Returns an array of all the CDs in the library. 
     * 
     * @return an array of all the CDs. 
     */
    public Resource[] getAllCDs() {
        // Creates an array of CDs 
        List<Resource> cds = new ArrayList<>();
        // Iterates through each element of the resources list
        for (Resource r : resources) {
            // Checks if the element is null and is an instance of the CD class
            if (r != null && r instanceof CD) {
                // If it is, adds it to the cds list
                cds.add(r);
            }
        }
        // Returns the conversion of the resources list to an array
        return cds.toArray(new Resource[0]);
    }
}