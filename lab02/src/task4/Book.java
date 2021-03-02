package task4;

import java.io.*;
import java.util.*;

public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String toString() {
        return "Cartea " + title +
                " este scrisa de " + author +
                " in anul " + year;
    }
}