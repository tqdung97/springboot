package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.request.UpsertBookRequest;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    @Autowired //inject bean
    private BookService bookService;

    // GET: api/v1/books : Lấy danh sách tât cả book
    @GetMapping("")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    //POST : api/v1/books : tạo mới book -> đối tượng sau khi tạo
    @PostMapping("")
    public Book createBook(@RequestBody UpsertBookRequest request) {
        return bookService.createBook(request);
    }

    // GET: api/v1/books/{id} : Lấy chi tiết 1 cuốn sách
    @GetMapping("{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    // PUT:  api/v1/books/{id} : Cập nhập thông tin cuốn sách  -> Đối tượng sách sau khi cập nhập
    @PutMapping("{id}")
    public Book updateBook(@PathVariable int id, @RequestBody UpsertBookRequest request) {
        return bookService.updateBook(id, request);
    }

    // DELETE : api/v1/books/{id} : Xóa cuốn sách theo id
    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }
}
