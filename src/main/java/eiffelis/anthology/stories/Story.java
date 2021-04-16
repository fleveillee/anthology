package eiffelis.anthology.stories;

import eiffelis.anthology.BaseTextEntity;
import eiffelis.anthology.authors.Author;
import eiffelis.anthology.chapters.Chapter;
import eiffelis.anthology.tags.Tag;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Story extends BaseTextEntity {

    @Transient
    private final Set<Author> authors = new HashSet<>();
    @Transient
    private final Set<Tag> tags = new HashSet<>();

    @OneToMany
    @OrderBy("number")
    private Set<Chapter> chapters = new HashSet<>();

    public Story() {
    }

    public Story(String title, String summary) {
        this.setTitle(title);
        this.setSummary(summary);
    }

    public Set<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(Set<Chapter> chapters) {
        this.chapters = chapters;
    }

    public void addChapter(Chapter chapter) {
        if (chapters == null || chapters.isEmpty()) {
            chapter.setNumber(1);
        } else {
            chapter.setNumber(this.chapters.size() + 1);
        }

        this.chapters.add(chapter);
    }

    @PostLoad
    private void postLoad() {
        if (this.getChapters() != null) {
            this.getChapters().forEach(chapter -> {
                if (null != chapter.getAuthors()) {
                    this.authors.addAll(chapter.getAuthors());
                }
                if (null != chapter.getTags()) {
                    this.tags.addAll(chapter.getTags());
                }
            });
        }
    }
}



