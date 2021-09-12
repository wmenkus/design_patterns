package design_patterns.observer;

public class Store  implements Observer{
    private Subject subject;
    private GenLL<Book> bestSellers;

    /**
     * Constructs the Store with a subject that it will get updates from and a custom-built linked
     * list of the most recent best sellers. The linked list should only keep track of the five most
     * recent.
     * Also registers the Store with the subject.
     * @param subject the Subject that the Store will register with
     */
    public Store(Subject subject) {
        this.subject = subject;
        bestSellers = new GenLL<Book>();
        this.subject.registerObserver(this);
    }

    /**
     * Adds the new book to the best sellers list and removes the oldest book if there are more than
     * five books.
     * @param book the new book that will be added
     */
    public void update(Book book) {
        bestSellers.insert(book);
        if(bestSellers.length() > 5) {
            bestSellers.remove();
        }
    }

    /**
     * Prints the list of the top 5 best sellers by using some janky garbage code from my
     * algorithms class. I don't know why I couldn't find any other way to implement a queue,
     * but this was my solution.
     */
    public void display() {
        System.out.println("Top 5 Best Sellers:");
        for(int i = 0; i < bestSellers.length(); i++) {
            bestSellers.moveToIndex(i);
            System.out.println(" - " + bestSellers.getCurrent().toString());
        }
        System.out.println(); //Generates an extra line to match the output file exactly
    }
}
