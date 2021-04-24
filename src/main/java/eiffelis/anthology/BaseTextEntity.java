package eiffelis.anthology;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
abstract public class BaseTextEntity extends BaseEntity {
    @Column(nullable = false, unique = true)
    protected String title;

    @Lob
    protected String summary;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        this.setSlug(this.getTitle());
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
