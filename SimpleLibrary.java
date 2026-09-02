package Lesson3;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private boolean available;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void lend() {
        available = false;
    }

    public void giveBack() {
        available = true;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               " | Title: " + title +
               " | Available: " + (available ? "Yes" : "No");
    }
}

public class SimpleLibrary {
    private static List<Book> catalog = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // some sample books
        catalog.add(new Book(nextId++, "Java Fundamentals"));
        catalog.add(new Book(nextId++, "Data Structures"));
        catalog.add(new Book(nextId++, "Clean Code"));

        while (running) {
            System.out.println("\n=== LIBRARY LENDING MACHINE ===");
            System.out.println("1. List books");
            System.out.println("2. Add book");
            System.out.println("3. Lend book");
            System.out.println("4. Return book");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    listBooks();
                    break;
                case "2":
                    addBook(scanner);
                    break;
                case "3":
                    lendBook(scanner);
                    break;
                case "4":
                    returnBook(scanner);
                    break;
                case "5":
                    running = false;
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }

    private static void listBooks() {
        if (catalog.isEmpty()) {
            System.out.println("No books in catalog.");
            return;
        }
        System.out.println("\n--- BOOK CATALOG ---");
        for (Book b : catalog) {
            System.out.println(b);
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        Book book = new Book(nextId++, title);
        catalog.add(book);
        System.out.println("Added: " + book);
    }

    private static void lendBook(Scanner scanner) {
        System.out.print("Enter book ID to lend: ");
        int id = readInt(scanner);
        Book book = findBookById(id);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("Book is already lent out.");
        } else {
            book.lend();
            System.out.println("Lent: " + book.getTitle());
        }
    }

    private static void returnBook(Scanner scanner) {
        System.out.print("Enter book ID to return: ");
        int id = readInt(scanner);
        Book book = findBookById(id);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (book.isAvailable()) {
            System.out.println("Book is not currently lent out.");
        } else {
            book.giveBack();
            System.out.println("Returned: " + book.getTitle());
        }
    }

    private static Book findBookById(int id) {
        for (Book b : catalog) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    private static int readInt(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number, treating as 0.");
            return 0;
        }
    }
}