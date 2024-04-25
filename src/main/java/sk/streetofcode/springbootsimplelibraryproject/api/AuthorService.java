package sk.streetofcode.springbootsimplelibraryproject.api;

import sk.streetofcode.springbootsimplelibraryproject.api.request.AddAuthorRequest;
import sk.streetofcode.springbootsimplelibraryproject.entity.Author;

import java.util.List;

public interface AuthorService {
    Author get(long id);

    List<Author> getAll();

    Long addAuthor(AddAuthorRequest authorRequest);
}
