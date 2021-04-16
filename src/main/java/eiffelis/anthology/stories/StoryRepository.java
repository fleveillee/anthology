package eiffelis.anthology.stories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StoryRepository extends JpaRepository<Story, UUID> {
    @Query("SELECT s FROM Story s WHERE s.title = :title AND (s.deletedDate IS NULL OR s.deletedDate > CURRENT_DATE ) ")
    Optional<Story> findStoryByTitle(@Param("title") String title);

    @Query("SELECT s FROM Story s WHERE s.slug = :slug AND (s.deletedDate IS NULL OR s.deletedDate > CURRENT_DATE ) ")
    Optional<Story> findStoryBySlug(@Param("slug") String slug);

    boolean existsByTitle(String title);

    boolean existsBySlug(String slug);
}
