package com.example.demo.controller;

import com.example.demo.service.BookService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@CrossOrigin
public class BookController {
    private final BookService bookService;

    @Autowired
    BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/books")
    public String getBooks() {
        return new Gson().toJson(bookService.getBooks());
    }

    @GetMapping(value = "/booksForUi")
    public String getBooksForUi() {
        return new Gson().toJson(bookService.getBooksForUi());
    }
}
