package com.example.LibraryInventory.Factory;

import com.example.LibraryInventory.Model.Book;

public class BookFactoryImpl implements BookFactory {

    @Override
    public Book createBook() {
        return new Book();
    }

    @Override
    public Book createBook(int id, String title, String author, int year, String genre) {
        return new Book(id, title, author, year, genre);
    }

}
