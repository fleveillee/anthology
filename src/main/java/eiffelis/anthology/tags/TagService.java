package eiffelis.anthology.tags;

import eiffelis.anthology.stories.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    private final StoryRepository storyRepository;
    private final TagRepository tagRepository;

    @Autowired
    public TagService(StoryRepository storyRepository, TagRepository tagRepository) {
        this.storyRepository = storyRepository;
        this.tagRepository = tagRepository;
    }

    public Tag findOneByName(String name) {
        return tagRepository.findOneByName(name);
    }

    public Tag findOneBySlug(String slug) {
        return tagRepository.findOneBySlug(slug);
    }

    public List<Tag> findAll() {
        List<Tag> tags = tagRepository.findAll();

        for (Tag tag : tags) {
            int storiesCount = storyRepository.countByTags(tag.getId());
            tag.setStoriesCount(storiesCount);
        }
        return tags;
    }
}
