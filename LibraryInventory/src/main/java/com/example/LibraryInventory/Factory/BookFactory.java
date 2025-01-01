package com.example.LibraryInventory.Factory;

import com.example.LibraryInventory.Model.Book;

public interface BookFactory {
    Book createBook(int id, String title, String author, int year, String genre);

    Book createBook();
}
