import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

class Patron {
    private String patronId;
    private String name;

    public Patron(String patronId, String name) {
        this.patronId = patronId;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class LibraryStaff {
    public void addBookToLibrary(Book book, List<Book> libraryCatalog) {
        libraryCatalog.add(book);
    }

    public void removeBookFromLibrary(Book book, List<Book> libraryCatalog) {
        libraryCatalog.remove(book);
    }

    public void registerPatron(Patron patron, List<Patron> patrons) {
        patrons.add(patron);
    }
}

class LibraryManagement {
    public boolean borrowBook(String name, List<Book> libraryCatalog) {
        for (Book book : libraryCatalog) {
            if (book.getTitle().toLowerCase().contains(name.toLowerCase())) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Book '" + book.getTitle() + "' has been borrowed.");
                    return true;
                } else {
                    System.out.println("Sorry, the book is not available for borrowing.");
                    return false;
                }
            }
        }
        System.out.println("Book not found.");
        return false;
    }

    public void returnBook(String name, Book book) {
        if (!book.isAvailable()) {
            book.setAvailable(true);
            System.out.println("Book '" + book.getTitle() + "' has been returned.");
        } else {
            System.out.println("This book is already in the library's collection.");
        }
    }

    public List<Book> searchBooks(String keyword, List<Book> libraryCatalog) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : libraryCatalog) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<Book> libraryCatalog = new ArrayList<>();
        List<Patron> patrons = new ArrayList<>();
        LibraryStaff l1 = new LibraryStaff();
        LibraryManagement lms = new LibraryManagement();
        Scanner scan = new Scanner(System.in);
        int option = 0;

        while (option != 7) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Register Patron");
            System.out.println("2. Add Books");
            System.out.println("3. Search Books");
            System.out.println("4. Borrow Books");
            System.out.println("5. Return Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter the Patron Id: ");
                    String patronId = scan.next();
                    System.out.print("Enter the Patron Name: ");
                    String patronName = scan.next();
                    Patron p1 = new Patron(patronId, patronName);
                    l1.registerPatron(p1, patrons);
                    System.out.println("Patron '" + patronName + "' has been registered.");
                    break;

                case 2:
                    System.out.print("Enter the Book Id: ");
                    String bookId = scan.next();
                    System.out.print("Enter the Book Title: ");
                    String title = scan.next();
                    System.out.print("Enter the Book Author: ");
                    String author = scan.next();
                    Book b1 = new Book(bookId, title, author);
                    l1.addBookToLibrary(b1, libraryCatalog);
                    System.out.println("Book '" + title + "' by " + author + " has been added.");
                    break;

                case 3:
                    System.out.print("Enter the book name or author: ");
                    String searchKeyword = scan.next();
                    List<Book> searchResults = lms.searchBooks(searchKeyword, libraryCatalog);
                    if (!searchResults.isEmpty()) {
                        System.out.println("Search Results:");
                        for (Book result : searchResults) {
                            System.out.println("Title: " + result.getTitle() + ", Author: " + result.getAuthor());
                        }
                    } else {
                        System.out.println("No books found matching the search criteria.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the book title to borrow: ");
                    String borrowTitle = scan.next();
                    lms.borrowBook(borrowTitle, libraryCatalog);
                    break;

                case 5:
                    System.out.print("Enter the book title to return: ");
                    String returnTitle = scan.next();
                    for (Book book : libraryCatalog) {
                        if (book.getTitle().equalsIgnoreCase(returnTitle)) {
                            lms.returnBook(returnTitle, book);
                            break;
                        }
                    }
                    break;

                case 6:
                    System.out.println("Exiting the Library Management System. Goodbye!");
                    scan.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
        scan.close();
    }
}
