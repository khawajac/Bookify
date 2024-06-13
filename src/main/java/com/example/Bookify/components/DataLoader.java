package com.example.Bookify.components;

import com.example.Bookify.models.*;
import com.example.Bookify.repositories.BookRepository;
import com.example.Bookify.repositories.UserRepository;
import com.example.Bookify.repositories.UsersBooksRepository;
import com.example.Bookify.services.BookService;
import com.example.Bookify.services.BookshelfService;
import com.example.Bookify.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Autowired
    BookshelfService bookshelfService;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UsersBooksRepository usersBooksRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        User robbie = new User("Zinizanzo");
        userService.createUser(robbie);


        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4", LocalDate.of(1960, 7, 11), 4.28, Genre.FICTION);
        Book book2 = new Book("1984", "George Orwell", "978-0-452-28423-4", LocalDate.of(1949, 6, 8), 4.17, Genre.SCIENCE_FICTION);
        Book book3 = new Book("Moby Dick", "Herman Melville", "978-0-14-243724-7", LocalDate.of(1851, 11, 14), 3.5, Genre.FICTION);
        Book book4 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0-7432-7356-5", LocalDate.of(1925, 4, 10), 3.92, Genre.FICTION);
        Book book5 = new Book("Pride and Prejudice", "Jane Austen", "978-0-19-280238-5", LocalDate.of(1813, 1, 28), 4.26, Genre.ROMANCE);

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);
        bookRepository.save(book5);

        List<Book> robbieBooks = new ArrayList<>();

        Bookshelf bookshelf1 = new Bookshelf(robbie,"Robbie's Bookshelf");


        bookshelfService.createBookshelf(bookshelf1);
        bookshelfService.addBookToBookshelf(1,book1);
        bookshelfService.addBookToBookshelf(1,book2);
        bookshelfService.addBookToBookshelf(1,book3);
        bookshelfService.addBookToBookshelf(1,book4);
        bookshelfService.addBookToBookshelf(1,book5);

        UsersBooks newUsersBook2 = new UsersBooks(robbie, book1);
        usersBooksRepository.save(newUsersBook2);
        UsersBooks newUsersBook3 = new UsersBooks(robbie, book2);
        usersBooksRepository.save(newUsersBook3);
        UsersBooks newUsersBook4 = new UsersBooks(robbie, book3);
        usersBooksRepository.save(newUsersBook4);


        User charisma = new User("CHRIMPY");
        userService.createUser(charisma);
        Book book6 = new Book("A Day of Fallen Night", "Samantha Shannon", "978-1-5266-1981-5", LocalDate.of(2023, 2, 28), 4.4, Genre.FANTASY);
        Bookshelf bookshelf2 = new Bookshelf(charisma, "Charisma's bookshelf");
        bookshelfService.createBookshelf(bookshelf2);

        bookRepository.save(book6);
        bookshelfService.addBookToBookshelf(2, book6);

        UsersBooks newUsersBook1 = new UsersBooks(charisma, book6);
        usersBooksRepository.save(newUsersBook1);


        User sabah = new User("Flakeymeerkat");
        userService.createUser(sabah);
        Book book7 = new Book("The Hobbit", "J.R.R. Tolkien", "978-0-618-00221-3", LocalDate.of(1937, 9, 21), 4.27, Genre.FANTASY);
        Book book8 = new Book("Crime and Punishment", "Fyodor Dostoevsky", "978-0-14-305814-4", LocalDate.of(1866, 1, 1), 4.21, Genre.FICTION);

        bookRepository.save(book7);
        bookRepository.save(book8);

//        ReadingStatus readingStatusSabah = ReadingStatus.CURRENTLY_READING;

        UsersBooks newUsersBook = new UsersBooks(sabah, book8);
        usersBooksRepository.save(newUsersBook);




    }

}
