package eiffelis.anthology.chapters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ChapterRepository extends JpaRepository<eiffelis.anthology.chapters.Chapter, Long> {
    Optional<Chapter> findByTitle(@Param("title") String title);

    Optional<Chapter> findBySlug(@Param("slug") String slug);

    boolean existsBySlug(String slug);
}
