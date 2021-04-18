package eiffelis.anthology.authors;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
    boolean existsByName(String name);

    Optional<Author> getByName(String name);
}
