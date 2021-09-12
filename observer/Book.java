package design_patterns.observer;

public class Book {
    private String title;
    private String authorFirstName;
    private String authorLastName;

    /**
     * Constructs a book with a given title and author's first and last name.
     * @param title the title of the book
     * @param authorFirstName the author's first name
     * @param authorLastName the author's last name. Really self explanatory, but javadoc is javadoc
     */
    public Book(String title, String authorFirstName, String authorLastName) {
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
    }

    /**
     * Accessor for the book's title
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Accessor for the author's first name
     * @return the author's first name
     */
    public String getAuthorFirstName() {
        return authorFirstName;
    }

    /**
     * Accessor for the author's last name
     * @return the author's last name
     */
    public String getAuthorLastName() {
        return authorLastName;
    }

    /**
     * Converts the book's information into a readable string in the form
     * Title by: Firstname Lastname
     */
    public String toString() {
        return title + " by: " + authorFirstName + " " + authorLastName;
    }

}