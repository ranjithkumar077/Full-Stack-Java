import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

abstract class User {
    protected String id, name, email, password;
    
    public User(String id, String name, String email, String password) {
        this.id = id; this.name = name; this.email = email; this.password = password;
    }
    
    public abstract void showMenu();
    public String getId() { return id; }
    public String getName() { return name; }
}

class Book {
    private static int count = 1;
    private String id, title, author, genre;
    private double price;
    private boolean issued = false;
    private String issuedTo;
    private LocalDate issueDate;
    
    public Book(String title, String author, String genre, double price) {
        this.id = "B" + String.format("%03d", count++);
        this.title = title; this.author = author; 
        this.genre = genre; this.price = price;
    }
    
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public boolean isIssued() { return issued; }
    public String getIssuedTo() { return issuedTo; }
    public LocalDate getIssueDate() { return issueDate; }
    
    public void issueBook(String userId) {
        issued = true; issuedTo = userId; issueDate = LocalDate.now();
    }
    
    public void returnBook() {
        issued = false; issuedTo = null; issueDate = null;
    }
    
    public double calculateFine() {
        if (!issued || issueDate == null) return 0;
        long days = ChronoUnit.DAYS.between(issueDate, LocalDate.now());
        return Math.max(0, days - 14) * 5.0;
    }
    
    @Override
    public String toString() {
        return String.format("ID: %-5s | %-25s | %-15s | %-10s | ₹%-6.0f | %s",
            id, title, author, genre, price, 
            issued ? "Issued to: " + issuedTo : "Available");
    }
}

class Library {
    static Map<String, Book> books = new HashMap<>();
    static List<User> users = new ArrayList<>();
    
    static void initializeData() {
        Book[] sampleBooks = {
            new Book("Clean Code", "Robert C. Martin", "Programming", 599),
            new Book("Head First Java", "Kathy Sierra", "Java", 899),
            new Book("The Alchemist", "Paulo Coelho", "Fiction", 299),
            new Book("Effective Java", "Joshua Bloch", "Java", 799),
            new Book("Design Patterns", "Gang of Four", "Design", 1299)
        };
        
        for (Book book : sampleBooks) {
            books.put(book.getId(), book);
        }
        System.out.println("Library Management System initialized with 5 sample books.");
    }
    
    static void displayAllBooks() {
        System.out.println("\n=== ALL BOOKS ===");
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        books.values().stream().sorted(Comparator.comparing(Book::getId)).forEach(System.out::println);
    }
    
    static Book findBook(String bookId) {
        return books.get(bookId.toUpperCase());
    }
    
    static void addBook(String title, String author, String genre, double price) {
        Book book = new Book(title, author, genre, price);
        books.put(book.getId(), book);
        System.out.println("Book added successfully. ID: " + book.getId());
    }
    
    static List<Book> searchBooks(String query) {
        List<Book> results = new ArrayList<>();
        String q = query.toLowerCase();
        for (Book book : books.values()) {
            if (book.getId().toLowerCase().contains(q) ||
                book.getTitle().toLowerCase().contains(q) ||
                book.getAuthor().toLowerCase().contains(q) ||
                book.getGenre().toLowerCase().contains(q)) {
                results.add(book);
            }
        }
        return results;
    }
}

class Admin extends User {
    public Admin(String id, String name, String email, String password) {
        super(id, name, email, password);
    }
    
    @Override
    public void showMenu() {
        System.out.println("\n=== ADMIN DASHBOARD ===");
        System.out.println("1. Add Book");
        System.out.println("2. View All Books");
        System.out.println("3. Search Books");
        System.out.println("4. Remove Book");
        System.out.println("5. View Issued Books");
        System.out.println("6. Logout");
    }
    
    public void addBook(Scanner sc) {
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();
        System.out.print("Enter Genre: ");
        String genre = sc.nextLine();
        System.out.print("Enter Price (INR): ");
        double price = 0;
        while(true) {
            try {
                price = Double.parseDouble(sc.nextLine());
                if(price < 0) throw new NumberFormatException();
                break;
            } catch(NumberFormatException e) {
                System.out.print("Invalid price. Enter again: ");
            }
        }
        
        Library.addBook(title, author, genre, price);
    }
    
    public void removeBook(Scanner sc) {
        System.out.print("Enter Book ID to remove: ");
        String bookId = sc.nextLine().toUpperCase();
        Book book = Library.findBook(bookId);
        if (book != null && !book.isIssued()) {
            Library.books.remove(bookId);
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found or currently issued.");
        }
    }
    
    public void searchBooks(Scanner sc) {
        System.out.print("Enter search term (title/author/genre): ");
        String query = sc.nextLine();
        List<Book> results = Library.searchBooks(query);
        if (results.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("\n=== SEARCH RESULTS ===");
            results.forEach(System.out::println);
        }
    }
}

class Student extends User {
    public Student(String id, String name, String email, String password) {
        super(id, name, email, password);
    }
    
    @Override
    public void showMenu() {
        System.out.println("\n=== STUDENT DASHBOARD ===");
        System.out.println("1. View All Books");
        System.out.println("2. Search Books");
        System.out.println("3. Issue Book");
        System.out.println("4. Return Book");
        System.out.println("5. Logout");
    }
    
    public void issueBook(Scanner sc) {
        Library.displayAllBooks();
        System.out.print("Enter Book ID to issue: ");
        String bookId = sc.nextLine().toUpperCase();
        Book book = Library.findBook(bookId);
        if (book != null && !book.isIssued()) {
            book.issueBook(this.getId());
            System.out.println("Book issued successfully. Due in 14 days.");
        } else {
            System.out.println("Book not available.");
        }
    }
    
    public void returnBook(Scanner sc) {
        boolean foundIssued = false;
        for (Book book : Library.books.values()) {
            if (book.isIssued() && book.getIssuedTo().equals(this.getId())) {
                double fine = book.calculateFine();
                book.returnBook();
                System.out.printf("Book returned. Fine: ₹%.2f%n", fine);
                foundIssued = true;
                break;
            }
        }
        if(!foundIssued) System.out.println("No issued books found.");
    }
    
    public void searchBooks(Scanner sc) {
        System.out.print("Enter search term (title/author/genre): ");
        String query = sc.nextLine();
        List<Book> results = Library.searchBooks(query);
        if (results.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("\n=== SEARCH RESULTS ===");
            results.forEach(System.out::println);
        }
    }
}

public class LSM{
    static User currentUser;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library.initializeData();
        System.out.println("Library Management System");
        System.out.println("========================");
        
        while(true) {
            showLoginMenu(sc);
            if(currentUser != null) {
                runDashboard(sc);
                currentUser = null; // logout
            }
        }
    }
    
    static void showLoginMenu(Scanner sc) {
        while(true) {
            System.out.println("\n=== LIBRARY MANAGEMENT SYSTEM ===");
            System.out.println("1. Admin Login");
            System.out.println("2. Student Login"); 
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            
            String choiceStr = sc.nextLine().trim();
            try {
                int choice = Integer.parseInt(choiceStr);
                switch (choice) {
                    case 1:
                        currentUser = new Admin("ADMIN001", "Library Administrator", 
                                              "admin@library.com", "admin123");
                        System.out.println("Admin login successful. Welcome, " + currentUser.getName());
                        return;
                    case 2:
                        currentUser = new Student("STU001", "John Doe", 
                                                "john.doe@student.com", "student123");
                        System.out.println("Student login successful. Welcome, " + currentUser.getName());
                        return;
                    case 3:
                        System.out.println("Thank you for using Library Management System.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid option. Please enter 1, 2, or 3.");
                }
            } catch(NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number (1-3).");
            }
        }
    }
    
    static void runDashboard(Scanner sc) {
        while(true) {
            currentUser.showMenu();
            System.out.print("Enter choice: ");
            String choiceStr = sc.nextLine().trim();
            try {
                int choice = Integer.parseInt(choiceStr);
                if(currentUser instanceof Admin) {
                    handleAdminChoice(choice, sc);
                    if(choice == 6) return;
                }
                else if(currentUser instanceof Student) {
                    handleStudentChoice(choice, sc);
                    if(choice == 5) return;
                }
            } catch(NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    
    static void handleAdminChoice(int choice, Scanner sc) {
        Admin admin = (Admin) currentUser;
        switch(choice) {
            case 1: admin.addBook(sc); break;
            case 2: Library.displayAllBooks(); break;
            case 3: admin.searchBooks(sc); break;
            case 4: admin.removeBook(sc); break;
            case 5: 
                System.out.println("\n=== ISSUED BOOKS ===");
                Library.books.values().stream()
                        .filter(Book::isIssued)
                        .forEach(System.out::println);
                break;
            case 6: System.out.println("Logging out..."); break;
            default: System.out.println("Invalid choice.");        
        }
    }
    
    static void handleStudentChoice(int choice, Scanner sc) {
        Student student = (Student) currentUser;
        switch(choice) {
            case 1: Library.displayAllBooks(); break;
            case 2: student.searchBooks(sc); break;
            case 3: student.issueBook(sc); break;
            case 4: student.returnBook(sc); break;
            case 5: System.out.println("Logging out..."); break;
            default: System.out.println("Invalid choice.");
        }
    }
}
