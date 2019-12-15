package design;

import java.util.HashMap;

public class OnlineReaderSystem {

    // Library, Book, User, UserManager, Display

    private Library library = new Library();
    private UserManager userManager = new UserManager();
    private Display display = new Display();
    private Book activeBook;
    private User activeUser;
    //    setActiveBook   activeBook=book & display.displayBook(book);
    //    setActiveUser   activeUser=user & display.displayUser(user);


    class Library {
        private HashMap<Integer, Book> books = new HashMap<>();
        // boolean addBook(Book book)
        // boolean remove(Book b)
        // Book find(int id)
    }

    class UserManager {
        private HashMap<Integer, User> users = new HashMap<Integer, User>();
        // boolean addUser(User user)
        // boolean remove(User user)
        // User find(int id)
    }

    class Display {
        private Book activeBook;
        private User activeUser;
        private int pageNumber = 0;

        // void displayUser(User user) => activeUser = user; refreshUsername();
        // void displayBook(Book book) => pageNumber = 0; activeBook = book; refreshTitle(); refreshDetails(); refreshPage();
        // void turnPageForward() => pageNumber++; refreshPage();
        // void turnPageBackward() => pageNumber--; refreshPage();
        // void refreshUsername();
        // void refreshTitle();
        // void refreshDetails();
        // void refreshPage();
    }

    class Book {
        private int bookId;
        private String details;
        private String title;
    }

    class User {
        private int userId;
        private String name;
        private String details;
        // void renewMembership();
    }


    public static void main(String[] args) {
        OnlineReaderSystem onlineReaderSystem = new OnlineReaderSystem();
//        Book dsBook = new Book(1, "It contains Data Structures", "Ds");
//        Book algoBook = new Book(2, "It contains Algorithms", "Algo");
//
//        onlineReaderSystem.getLibrary().addBook(dsBook);
//        onlineReaderSystem.getLibrary().addBook(algoBook);
//
//        User user1 = new User(1, " ", "Ram");
//        User user2 = new User(2, " ", "Gopal");
//
//        onlineReaderSystem.getUserManager().addUser(user1);
//        onlineReaderSystem.getUserManager().addUser(user2);
//
//        onlineReaderSystem.setActiveBook(algoBook);
//        onlineReaderSystem.setActiveUser(user1);
//
//        onlineReaderSystem.getDisplay().turnPageForward();
//        onlineReaderSystem.getDisplay().turnPageForward();
//        onlineReaderSystem.getDisplay().turnPageBackward();
    }
}

