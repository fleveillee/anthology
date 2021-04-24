package eiffelis.anthology.tags;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findOneByName(String name);

    Tag findOneBySlug(String slug);
}
