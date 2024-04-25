package sk.streetofcode.springbootsimplelibraryproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.streetofcode.springbootsimplelibraryproject.api.BookService;
import sk.streetofcode.springbootsimplelibraryproject.api.request.AddBookRequest;
import sk.streetofcode.springbootsimplelibraryproject.entity.Book;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(bookService.getAll());
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<List<Book>> getAll(@PathVariable long id) {
        return ResponseEntity.ok(bookService.getAllByAuthorId(id));
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBook(@PathVariable long id) {
        return ResponseEntity.ok(bookService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> addBook(@RequestBody AddBookRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(request));
    }
}
