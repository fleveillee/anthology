package eiffelis.anthology.chapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

@Service
public class ChapterService {

    private final ChapterRepository chapterRepository;

    @Autowired
    public ChapterService(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    public List<Chapter> getChapters() {
        return chapterRepository.findAll();
    }

    public void addChapter(Chapter chapter) {
        chapter.setCreatedDate(LocalDateTime.now());
        chapterRepository.save(chapter);
    }

    public void archiveChapter(UUID id) {
        boolean exists = chapterRepository.existsById(id);
        if (!exists) {
            throw new NoSuchElementException("No Chapter Found With ID " + id);
        } else {
            Chapter chapter = chapterRepository.getOne(id);
            if (chapter.getDeletedDate() != null) {
                throw new IllegalStateException("Chapter With ID " + id + " is already Archived");
            }
            chapter.setDeletedDate(LocalDateTime.now());
            chapterRepository.save(chapter);
        }
    }

    @Transactional
    public void updateChapter(UUID id, String title, String summary, String content, LocalDateTime publicationDate) {
        //region Description
        Chapter chapter = chapterRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Chapter with ID " + id + " could not be found."));
        //endregion

        if (title != null && title.length() > 0 && !Objects.equals(chapter.getTitle(), title)) {
            chapter.setTitle(title);
        }

        if (summary != null && summary.length() > 0 && !Objects.equals(chapter.getSummary(), summary)) {
            chapter.setSummary(summary);
        }

        if (content != null && content.length() > 0 && !Objects.equals(chapter.getContent(), content)) {
            chapter.setContent(content);
        }

        if (publicationDate != null && !Objects.equals(chapter.getPublicationDate(), publicationDate)) {
            chapter.setPublicationDate(publicationDate);
        }

    }

    public Chapter getChapterBySlug(String slug) {
        boolean exists = chapterRepository.existsBySlug(slug);
        if (!exists) {
            throw new NoSuchElementException("No Chapter Found With Slug " + slug);
        }
        return chapterRepository.findBySlug(slug).orElseThrow(() -> new NoSuchElementException("Chapter with Slug " + slug + " could not be found."));
    }
}
