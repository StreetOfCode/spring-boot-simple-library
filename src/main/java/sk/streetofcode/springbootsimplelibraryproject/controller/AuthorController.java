package sk.streetofcode.springbootsimplelibraryproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.streetofcode.springbootsimplelibraryproject.api.AuthorService;
import sk.streetofcode.springbootsimplelibraryproject.api.request.AddAuthorRequest;
import sk.streetofcode.springbootsimplelibraryproject.entity.Author;

import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAll() {
        return ResponseEntity.ok(authorService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable long id) {
        return ResponseEntity.ok(authorService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> addAuthor(@RequestBody AddAuthorRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.addAuthor(request));
    }
}
