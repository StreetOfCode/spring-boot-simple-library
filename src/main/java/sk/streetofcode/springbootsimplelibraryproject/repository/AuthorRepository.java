package sk.streetofcode.springbootsimplelibraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.streetofcode.springbootsimplelibraryproject.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
