package com.example.LibraryInventory.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.LibraryInventory.Exception.BookNotFoundException;
import com.example.LibraryInventory.Exception.DuplicateBookException;
import com.example.LibraryInventory.Model.Book;
import com.example.LibraryInventory.Factory.BookFactory;
import com.example.LibraryInventory.Factory.BookFactoryImpl;

@Service
public class LibraryService {
    private List<Book> bookCollection = new ArrayList<>();

    public String addBook(Book book) throws DuplicateBookException {
        boolean flag = false;
        for (Book b : bookCollection) {
            if (b.getId() == book.getId()) {
                flag = true;
            }
        }
        if (flag) {
            throw new DuplicateBookException("Book with Id: " + book.getId() + " already Exists!!!");
        } else {

            bookCollection.add(book);
            String res = "( " + book + " )" + " Is added to the Collection!!!";
            return res;
        }
    }

    public String removeBook(int bookId) throws BookNotFoundException {
        boolean flag = false;
        Book removedBook = new Book();
        for (Book b : bookCollection) {
            if (bookId == b.getId()) {
                flag = true;
                removedBook = b;
                bookCollection.remove(b);
                break;
            }
        }
        if (flag) {
            String res = "( " + removedBook + " )" + " Is removed from the Collection!!!";
            return res;
        } else {
            throw new BookNotFoundException("No Book with id: " + bookId + " is found !!!");
        }

    }

    public String removeBook(String title) throws BookNotFoundException {
        boolean flag = false;
        BookFactory bookFactory = new BookFactoryImpl();
        Book removedBook = bookFactory.createBook();
        for (Book b : bookCollection) {
            if (title.equals(b.getTitle())) {
                flag = true;
                removedBook = b;
                bookCollection.remove(b);
                break;
            }
        }
        if (flag) {
            String res = "( " + removedBook + " )" + " Is removed from the Collection!!!";
            return res;
        } else {
            throw new BookNotFoundException("No Book with title: " + title + " is found !!!");
        }

    }

    public List<Book> search(String author, String title, int year) throws BookNotFoundException {
        List<Book> result = bookCollection.stream()
                .filter(book -> title.length() == 0 || book.getTitle().equals(title))
                .filter(book -> author.length() == 0 || book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .filter(book -> year == 0 || book.getYear() == year)
                .collect(Collectors.toList());
        if (result.size() == 0) {
            throw new BookNotFoundException("No Book found against desired criteria!!!");
        } else {
            return result;
        }

    }

    public List<Book> display() throws BookNotFoundException {
        bookCollection.sort((a, b) -> (a.getId() - b.getId()));
        if (bookCollection.size() == 0) {
            throw new BookNotFoundException("The Library is Empty!!!");
        } else {
            return this.bookCollection;
        }
    }
}
