package eiffelis.anthology.tags;

import eiffelis.anthology.BaseEntity;
import eiffelis.anthology.chapters.Chapter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import java.util.List;

@Entity
@SQLDelete(sql = "UPDATE tag SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date IS NULL OR deleted_date > NOW()")
public class Tag extends BaseEntity {
    @Transient
    int storiesCount;
    @Column(length = 30, nullable = false, unique = true)
    private String name;
    @ManyToMany(mappedBy = "tags")
    private List<Chapter> chapters;

    public Tag() {
    }

    public Tag(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.setSlug(this.getName());
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public int getStoriesCount() {
        return storiesCount;
    }

    public void setStoriesCount(int storiesCount) {
        this.storiesCount = storiesCount;
    }
}
