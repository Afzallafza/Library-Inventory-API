package com.example.LibraryInventory.Model;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private int year;
    private String genre;

    public Book() {

    }

    public Book(int bookId, String title, String author, int year, String genre) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void getTitle(String title) {
        this.title = title;
    }

    public void getYear(int year) {
        this.year = year;
    }

    public void getGenre(String genre) {
        this.genre = genre;
    }

    public void getAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return this.bookId;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getAuthor() {
        return this.author;
    }

    public String toString() {
        String ss = "Id: " + this.bookId + " Title: " + this.title + " Author: " + this.author + " Publication Year: "
                + this.year + " Genre: " + this.genre;
        return ss;
    }

}
