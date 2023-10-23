import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrow() {
        if (isAvailable) {
            isAvailable = false;
        } else {
            System.out.println("This book is already borrowed.");
        }
    }

    public void returnBook() {
        isAvailable = true;
    }
}

class Patron {
    private String name;

    public Patron(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class LibraryStaff {
    private List<Book> catalog;
    private List<Patron> patrons;

    public LibraryStaff() {
        catalog = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    public void addBookToCatalog(Book book) {
        catalog.add(book);
    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public void lendBook(Book book, Patron patron) {
        if (catalog.contains(book) && patrons.contains(patron)) {
            if (book.isAvailable()) {
                book.borrow();
                System.out.println("Book '" + book.getTitle() + "' has been borrowed by " + patron.getName() + ".");
            } else {
                System.out.println("Book '" + book.getTitle() + "' is not available for borrowing.");
            }
        } else {
            System.out.println("Book or patron not found in the library.");
        }
    }

    public void returnBook(Book book, Patron patron) {
        if (catalog.contains(book) && patrons.contains(patron)) {
            if (!book.isAvailable()) {
                book.returnBook();
                System.out.println("Book '" + book.getTitle() + "' has been returned by " + patron.getName() + ".");
            } else {
                System.out.println("Book '" + book.getTitle() + "' is already available.");
            }
        } else {
            System.out.println("Book or patron not found in the library.");
        }
    }

    public void searchForBook(String title) {
        for (Book book : catalog) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: '" + book.getTitle() + "' by " + book.getAuthor() + (book.isAvailable() ? " (Available)" : " (Not Available)"));
                return;
            }
        }
        System.out.println("Book not found: '" + title + "'");
    }
}

public class Library {
    public static void main(String[] args) {
        LibraryStaff library = new LibraryStaff();

        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("1984", "George Orwell");

        Patron patron1 = new Patron("Alice");
        Patron patron2 = new Patron("Bob");

        library.addBookToCatalog(book1);
        library.addBookToCatalog(book2);
        library.addBookToCatalog(book3);

        library.addPatron(patron1);
        library.addPatron(patron2);

        library.lendBook(book1, patron1);
        library.lendBook(book2, patron2);

        library.returnBook(book1, patron1);

        library.searchForBook("1984");
        library.searchForBook("Harry Potter");
    }
}
