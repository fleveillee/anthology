package eiffelis.anthology.authors;

import eiffelis.anthology.BaseEntity;
import eiffelis.anthology.chapters.Chapter;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Inheritance
public class Author extends BaseEntity {
    @Basic(optional = false)
    private String name;

    @ManyToMany(mappedBy = "authors")
    private Set<Chapter> stories;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Chapter> getStories() {
        return stories;
    }

    public void setStories(Set<Chapter> stories) {
        this.stories = stories;
    }
}
