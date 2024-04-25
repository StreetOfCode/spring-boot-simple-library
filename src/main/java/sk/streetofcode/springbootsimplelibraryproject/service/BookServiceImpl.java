package sk.streetofcode.springbootsimplelibraryproject.service;

import org.springframework.stereotype.Service;
import sk.streetofcode.springbootsimplelibraryproject.api.AuthorService;
import sk.streetofcode.springbootsimplelibraryproject.api.BookService;
import sk.streetofcode.springbootsimplelibraryproject.api.exception.ResourceNotFoundException;
import sk.streetofcode.springbootsimplelibraryproject.api.request.AddBookRequest;
import sk.streetofcode.springbootsimplelibraryproject.entity.Author;
import sk.streetofcode.springbootsimplelibraryproject.entity.Book;
import sk.streetofcode.springbootsimplelibraryproject.repository.BookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository repository, AuthorService authorService) {
        this.repository = repository;
        this.authorService = authorService;
    }

    @Override
    public Book get(long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));
    }

    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Book> getAllByAuthorId(long authorId) {
        return repository.findAllByAuthorId(authorId);
    }

    @Override
    public Long addBook(AddBookRequest request) {
        Author author = authorService.get(request.getAuthorId());
        Book book = new Book(request.getTitle(), request.getDescription(), author);
        return repository.save(book).getId();
    }
}
