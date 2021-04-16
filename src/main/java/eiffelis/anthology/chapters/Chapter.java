package eiffelis.anthology.chapters;

import eiffelis.anthology.BaseTextEntity;
import eiffelis.anthology.authors.Author;
import eiffelis.anthology.stories.Story;
import eiffelis.anthology.tags.Tag;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Chapter extends BaseTextEntity {

    @ManyToOne
    private Story story;

    private Integer number;

    @Lob
    private String content;

    private LocalDateTime publicationDate;

    @ManyToMany
    private Set<Author> authors;

    @ManyToMany
    private Set<Tag> tags;


    public Chapter() {
    }

    public Chapter(String title, String summary, String content) {
        this.setTitle(title);
        this.setSummary(summary);
        this.setContent(content);
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }


    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @PrePersist
    public void findNextAvailableNumber() {
        if (this.getNumber() == null) {
            if (this.getStory().getChapters().isEmpty()) {
                this.setNumber(1);
            } else {
                this.setNumber(this.getStory().getChapters().size() + 1);
            }
        }
    }
}
