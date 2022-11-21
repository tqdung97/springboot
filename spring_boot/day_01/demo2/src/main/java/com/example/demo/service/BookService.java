package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.request.UpsertBookRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();;
    public BookService(){


     Book book = new Book(1,"B1","D1",1998);
        Book book2 = new Book(2,"B2","D2",1998);
     books.add(book);
     books.add(book2);

    }
    public List<Book> getBooks(){
        return books;
    }

    public Book getBookById(int id){
        for(Book book : books){
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }


    public Book createBook(UpsertBookRequest request){
        Random rd = new Random();
        int id = rd.nextInt(1000);
        Book book = new Book(id,
                request.getTitle(),
                request.getDescription(),
                request.getPublishYear());
        books.add(book);
        return book;
    }

    public Book updateBook(int id, UpsertBookRequest request){
        for(Book book : books){
            if(book.getId() == id){
                book.setTitle(request.getTitle());
                book.setDescription(request.getDescription());
                book.setPublishYear(request.getPublishYear());
                return book;
            }
        }
        return null;
    }


    public void deleteBook(int id){
        for (Book book: books){
            if(book.getId() == id){
                books.remove(id);
            }
        }
    }


}
