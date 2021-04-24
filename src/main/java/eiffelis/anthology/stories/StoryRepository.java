package eiffelis.anthology.stories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface StoryRepository extends JpaRepository<Story, UUID> {
    Story findByTitle(@Param("title") String title);

    Story findBySlug(@Param("slug") String slug);

    @Query("SELECT s FROM Story s INNER JOIN s.chapters c  INNER JOIN c.authors a WHERE a.id = :authorId GROUP BY s.id")
    Set<Story> findByAuthor(int authorId);

    @Query("SELECT s FROM Story s INNER JOIN s.chapters c  INNER JOIN c.tags t WHERE t.id = :tagId GROUP BY s.id")
    Set<Story> findByTags(int tagId);

    @Query("SELECT s FROM Story s INNER JOIN s.chapters c GROUP BY s.id")
    List<Story> findAllWithChapters();

    @Query("SELECT COUNT(DISTINCT s) FROM Story s INNER JOIN s.chapters c  INNER JOIN c.authors a WHERE a.id = :authorId")
    int countByAuthors(int authorId);

    @Query("SELECT COUNT(DISTINCT s) FROM Story s INNER JOIN s.chapters c  INNER JOIN c.tags t WHERE t.id = :tagId")
    int countByTags(int tagId);
}
