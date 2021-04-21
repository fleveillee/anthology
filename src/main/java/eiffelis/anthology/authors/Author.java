package eiffelis.anthology.authors;

import eiffelis.anthology.BaseEntity;
import eiffelis.anthology.chapters.Chapter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@SQLDelete(sql = "UPDATE author SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date IS NULL OR deleted_date > NOW()")
public class Author extends BaseEntity {
    @Basic(optional = false)
    private String name;

    @ManyToMany(mappedBy = "authors")
    private Set<Chapter> stories;

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

    public Set<Chapter> getStories() {
        return stories;
    }

    public void setStories(Set<Chapter> stories) {
        this.stories = stories;
    }
}
