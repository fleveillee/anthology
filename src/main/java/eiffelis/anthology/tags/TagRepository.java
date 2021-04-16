package eiffelis.anthology.tags;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TagRepository extends JpaRepository<Tag, UUID> {

    boolean existsByName(String name);

    @Query("SELECT t FROM Tag t WHERE t.name = :name AND (t.deletedDate IS NULL OR t.deletedDate > CURRENT_DATE ) ")
    Optional<Tag> findTagByName(String name);
}
