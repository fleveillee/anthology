package eiffelis.anthology.authors;

import eiffelis.anthology.BaseEntity;
import eiffelis.anthology.chapters.Chapter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import java.util.Set;

@Entity
@SQLDelete(sql = "UPDATE author SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date IS NULL OR deleted_date > NOW()")
public class Author extends BaseEntity {

    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "authors")
    private Set<Chapter> chapters;

    @Transient
    private int storiesCount;


    public Author() {
    }

    public Author(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.setSlug(this.getName());
    }

    public Set<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(Set<Chapter> stories) {
        this.chapters = stories;
    }

    public int getStoriesCount() {
        return storiesCount;
    }

    public void setStoriesCount(int storiesCount) {
        this.storiesCount = storiesCount;
    }
}
