package eiffelis.anthology;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
abstract public class BaseTextEntity extends BaseEntity {
    protected String title;
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
