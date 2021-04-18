package eiffelis.anthology.stories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StoryRepository extends JpaRepository<Story, UUID> {
    boolean existsByTitle(String title);

    boolean existsBySlug(String slug);

    Optional<Story> findByTitle(@Param("title") String title);

    Optional<Story> findBySlug(@Param("slug") String slug);
}
