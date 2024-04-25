package sk.streetofcode.springbootsimplelibraryproject.api;

import sk.streetofcode.springbootsimplelibraryproject.api.request.AddBookRequest;
import sk.streetofcode.springbootsimplelibraryproject.entity.Book;

import java.util.List;

public interface BookService {
    Book get(long id);

    List<Book> getAll();

    List<Book> getAllByAuthorId(long authorId);

    Long addBook(AddBookRequest bookRequest);
}
