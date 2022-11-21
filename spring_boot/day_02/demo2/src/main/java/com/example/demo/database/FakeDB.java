package com.example.demo.database;

import com.example.demo.model.Book;

import java.util.ArrayList;
import java.util.List;

public class FakeDB {
    public static List<Book> books = new ArrayList<>(List.of(
            new Book(1, "B1", "D1", 1998),
            new Book(2, "B2", "D2", 1998)
    ));

}
