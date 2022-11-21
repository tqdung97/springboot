package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.request.UpsertBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    ;
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks() {
        return null;
    }

    public Book getBookById(int id) {

        //Cách 1
//        Optional<Book> bookOptional = bookRepository.findById(id);
//        if(bookOptional.isPresent()){
//            return bookOptional.get();
//        }
//        throw new NotFoundException("Not found book with id = " + id);
        //Cách 2:
        return bookRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found book with id = " + id);
        });
    }


    public Book createBook(UpsertBookRequest request) {
        Random rd = new Random();
        int id = rd.nextInt(1000);
        Book book = new Book(id,
                request.getTitle(),
                request.getDescription(),
                request.getPublishYear());
        bookRepository.save(book);
        return book;
    }

    public Book updateBook(int id, UpsertBookRequest request) {
        Book book = bookRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found book with id = " + id);
        });
        book.setTitle(request.getTitle());
        book.setDescription(request.getDescription());
        book.setPublishYear(request.getPublishYear());
        return book;

    }


    public void deleteBook(int id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found book with id = " + id);
        });
        bookRepository.delete(book);

    }


}
