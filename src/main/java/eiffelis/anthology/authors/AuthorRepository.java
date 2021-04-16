package eiffelis.anthology.authors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
    boolean existsByName(String name);

    @Query("SELECT a FROM Author a WHERE a.name = :name AND (a.deletedDate IS NULL OR a.deletedDate > CURRENT_DATE )")
    Optional<Author> getByName(String name);
}
