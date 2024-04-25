package sk.streetofcode.springbootsimplelibraryproject.service;

import org.springframework.stereotype.Service;
import sk.streetofcode.springbootsimplelibraryproject.api.AuthorService;
import sk.streetofcode.springbootsimplelibraryproject.api.exception.ResourceNotFoundException;
import sk.streetofcode.springbootsimplelibraryproject.api.request.AddAuthorRequest;
import sk.streetofcode.springbootsimplelibraryproject.entity.Author;
import sk.streetofcode.springbootsimplelibraryproject.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;

    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Author get(long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id " + id + " not found"));
    }

    @Override
    public List<Author> getAll() {
        return repository.findAll();
    }

    @Override
    public Long addAuthor(AddAuthorRequest request) {
        final Author author = new Author(request.getName());
        return repository.save(author).getId();
    }
}
