package eiffelis.anthology.stories;

import eiffelis.anthology.authors.Author;
import eiffelis.anthology.tags.Tag;
import org.springframework.stereotype.Service;

import javax.naming.OperationNotSupportedException;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

@Service
public class StoryService {
    private final StoryRepository storyRepository;

    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public List<Story> getStories() {
        return storyRepository.findAllWithChapters();
    }

    public void addStory(Story story) {
        storyRepository.save(story);
    }

    public void archiveStory(UUID id) throws OperationNotSupportedException {
        boolean exists = storyRepository.existsById(id);
        if (!exists) {
            throw new NoSuchElementException("No Story Found With ID " + id);
        } else {
            Story story = storyRepository.getOne(id);
            if (story.getDeletedDate() != null) {
                throw new OperationNotSupportedException("Story With ID " + id + " is already in thrash can.");
            }
            story.setDeletedDate(LocalDateTime.now());
            storyRepository.save(story);
        }
    }

    @Transactional
    public void updateStory(UUID id, String title, String summary) {
        Story story = storyRepository.findById(id)
                                     .orElseThrow(() -> new NoSuchElementException("Story with ID " + id + " could not be found."));

        story.setTitle(title);
        story.setSummary(summary);

        storyRepository.save(story);
    }

    public Set<Story> findByAuthor(Author author) {
        return this.storyRepository.findByAuthor(author.getId());
    }

    public Set<Story> findByTag(Tag tag) {
        return this.storyRepository.findByTags(tag.getId());
    }

    public Story getStoryBySlug(String slug) {
        return storyRepository.findBySlug(slug);
    }


    public Story getStoryByTitle(String title) {
        return storyRepository.findByTitle(title);
    }
}
