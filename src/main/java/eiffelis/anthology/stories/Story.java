package eiffelis.anthology.stories;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    private String title;
    private String summary;
    private String content;

    private LocalDateTime creationDate;
    private LocalDateTime publicationDate;
    private LocalDateTime removalDate;

    public Story() {
    }

    public Story(String title, String summary, String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public Story(String title, String summary, String content, LocalDateTime publicationDate) {
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.publicationDate = publicationDate;
    }

    public Story(UUID id, String title, String summary, String content, LocalDateTime creationDate, LocalDateTime publicationDate, LocalDateTime removalDate) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.creationDate = creationDate;
        this.publicationDate = publicationDate;
        this.removalDate = removalDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public LocalDateTime getRemovalDate() {
        return removalDate;
    }

    public void setRemovalDate(LocalDateTime removalDate) {
        this.removalDate = removalDate;
    }
}
