package observer;

import java.util.ArrayList;

public class Customer implements Observer{
    private Subject subject;
    private String firstName;
    private String lastName;
    private ArrayList<Book> wishList;

    /**
     * Constructs a Customer with a given first name, last name, and subject that they will
     * get updates about new books from. Also constructs an empty wish list for them to add
     * books to.
     * @param subject the subject that the Customer will get updates about new books from.
     * @param firstName the first name of the Customer
     * @param lastName the last name of the Customer //TODO these are not used
     */
    public Customer(Subject subject, String firstName, String lastName) {
        this.subject = subject;
        this.firstName = firstName;
        this.lastName = lastName;
        wishList = new ArrayList<Book>();
        this.subject.registerObserver(this);
    }

    /**
     * The update method called from the subject's notify method. Gets notified of a new book
     * and adds it to the wish list.
     * @param book the new book to be added to the wish list
     */
    public void update(Book book) {
        wishList.add(book);
    }

    /**
     * Prints out the wish list. This is far less janky than the Store's version, although I should
     * have used a for-each loop.
     */
    public void display() {
        System.out.println("Wish List:");
        for(int i = 0; i < wishList.size(); i++) {
            System.out.println(" - " + wishList.get(i).toString());
        }
    }
}
