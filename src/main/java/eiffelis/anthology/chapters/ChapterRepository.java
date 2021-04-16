package eiffelis.anthology.chapters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChapterRepository extends JpaRepository<eiffelis.anthology.chapters.Chapter, UUID> {
    @Query("SELECT c FROM Chapter c WHERE c.title = :title AND (c.deletedDate IS NULL OR c.deletedDate > CURRENT_DATE ) ")
    Optional<Chapter> findChapterByTitle(@Param("title") String title);

    @Query("SELECT c FROM Chapter c WHERE c.slug = :slug AND (c.deletedDate IS NULL OR c.deletedDate > CURRENT_DATE ) ")
    Optional<Chapter> findChapterBySlug(@Param("slug") String slug);

    boolean existsBySlug(String slug);
}
