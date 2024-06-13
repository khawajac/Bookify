package com.example.Bookify.controllers;


import com.example.Bookify.models.Book;
import com.example.Bookify.models.ReadingStatus;
import com.example.Bookify.models.UsersBooks;
import com.example.Bookify.services.UsersBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users-books")
public class UsersBooksController {

    @Autowired
    UsersBooksService usersBooksService;

    //    Retrieve all users books
    @GetMapping
    public ResponseEntity<List<UsersBooks>> getAllUsersBooks(){
        List<UsersBooks> usersBooks = usersBooksService.getAllUsersBooks();
        return new ResponseEntity<>(usersBooks, HttpStatus.OK);
    }

<<<<<<< HEAD
//   Get a specific users book
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<UsersBooks>> getUsersBooksById(@PathVariable long id){
=======
//   Get a specific users books
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<List<UsersBooks>>> getSpecificUsersBooks(@PathVariable long id){
        Optional<List<UsersBooks>> specificUsersBooks = usersBooksService.getSpecificUsersBooks(id);
        return new ResponseEntity<>(specificUsersBooks, HttpStatus.OK);
    }

    //   Get a single book from a specific user
    @GetMapping(value = "/{id}/{bookId}")
    public ResponseEntity<Optional<UsersBooks>> getUsersBooksById(@PathVariable long id, @PathVariable long bookId){
>>>>>>> ba1448f9b8d1bf594abe23e68bb593828ca6af23
        Optional<UsersBooks> userbook = usersBooksService.getUsersBooksById(id);
        Optional<List<UsersBooks>> aUsersBook = usersBooksService.getSpecificUsersBooks(bookId);
        return new ResponseEntity<>(userbook, HttpStatus.OK);
    }

//    update reading status of specific book
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Optional<UsersBooks>> updateReadingStatus(@PathVariable long id, @RequestParam ReadingStatus readingStatus){
        Optional<UsersBooks> usersBooks = usersBooksService.getUsersBooksById(id);
        if (usersBooks.isPresent()){
            usersBooksService.updateReadingStatus(id, readingStatus);

            return new ResponseEntity<>(usersBooks, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
