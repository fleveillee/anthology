package eiffelis.anthology.tags;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TagRepository extends JpaRepository<Tag, UUID> {
    Tag findOneByName(String name);

    Tag findOneBySlug(String slug);
}
