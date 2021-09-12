package design_patterns.observer;

import java.util.ArrayList;

public class BestSellers implements Subject{
    private ArrayList<Observer> observers;
    private ArrayList<Book> bestSellers;

    /**
     * Constructor for the BestSellers class, creates an empty array list of best seller books and
     * an empty array list of observers that will be notified when a book is added.
     */
    public BestSellers() {
        observers = new ArrayList<Observer>();
        bestSellers = new ArrayList<Book>();
    }

    /**
     * Adds an Observer to the list of observers. This method will be called by the Observer itself.
     * @param observer the Observer to be added to the list
     */
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Removes an Observer from the list of observers.
     * @param observer the Observer to be removed from the list
     */
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Calls the update method for each Observer in the list of observers.
     * @param book the book that the observers are being notified of
     */
    public void notifyObservers(Book book) {
        for(Observer observer: observers) {
            observer.update(book);
        }
    }

    /**
     * Adds a book to the list of best seller books and notifies the observers about the new book.
     * @param book the book that is being added to the list
     */
    public void addBook(Book book) {
        bestSellers.add(book);
        notifyObservers(book);
    }
}
