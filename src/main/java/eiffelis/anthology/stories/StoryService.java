package eiffelis.anthology.stories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class StoryService {

    private final StoryRepository storyRepository;

    @Autowired
    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public List<Story> getStories() {
        return storyRepository.findAll();
    }

    public void addStory(Story story) {
        story.setCreationDate(LocalDateTime.now());
        storyRepository.save(story);
    }

    public void archiveStory(UUID id) {
        boolean exists = storyRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("No Story Found With ID " + id);
        } else {
            Story story = storyRepository.getOne(id);
            if (story.getRemovalDate() != null) {
                throw new IllegalStateException("Story With ID " + id + " is already Archived");
            }
            story.setRemovalDate(LocalDateTime.now());
            storyRepository.save(story);
        }


    }

    @Transactional
    public void updateStory(UUID id, String title, String summary, String content, LocalDateTime publicationDate) {
        Story story = storyRepository.findById(id).orElseThrow(() -> new IllegalStateException("Story with ID " + id + " could not be found."));

        if (title != null && title.length() > 0 && !Objects.equals(story.getTitle(), title)) {
            story.setTitle(title);
        }

        if (summary != null && summary.length() > 0 && !Objects.equals(story.getSummary(), summary)) {
            story.setSummary(summary);
        }

        if (content != null && content.length() > 0 && !Objects.equals(story.getContent(), content)) {
            story.setContent(content);
        }

        if (publicationDate != null && !Objects.equals(story.getPublicationDate(), publicationDate)) {
            story.setPublicationDate(publicationDate);
        }

    }
}
