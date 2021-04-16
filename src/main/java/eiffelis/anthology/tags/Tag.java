package eiffelis.anthology.tags;

import eiffelis.anthology.BaseEntity;
import eiffelis.anthology.chapters.Chapter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Tag extends BaseEntity {
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Chapter> chapters;

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }
}
