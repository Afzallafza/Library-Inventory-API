package com.example.LibraryInventory.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.LibraryInventory.Exception.BookNotFoundException;
import com.example.LibraryInventory.Exception.DuplicateBookException;
import com.example.LibraryInventory.Model.Book;
import com.example.LibraryInventory.Service.LibraryService;

@RestController
public class BookController {
    LibraryService library;

    @Autowired
    public BookController(LibraryService library) {
        this.library = library;
    }
    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(@RequestBody Book book) throws DuplicateBookException{
            String response = library.addBook(book);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<?> deleteBookById(@RequestParam("id") int id) {
        try {
            String response = library.removeBook(id);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (BookNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteByTitle")
    public ResponseEntity<?> deleteBookByTitle(@RequestParam("title") String title) {
        try {
            String response = library.removeBook(title);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (BookNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchBooks(@RequestParam(defaultValue = "0") int year,
            @RequestParam(defaultValue = "") String title, @RequestParam(defaultValue = "") String author) {
        try {
            List<Book> list = library.search(author, title, year);
            System.out.println(list);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (BookNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/books")
    public ResponseEntity<?> getBooks() {
        try {
            List<Book> list = library.display();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (BookNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
   
}
