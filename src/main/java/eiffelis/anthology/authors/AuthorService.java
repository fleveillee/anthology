package eiffelis.anthology.authors;

import eiffelis.anthology.stories.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final StoryRepository storyRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, StoryRepository storyRepository) {
        this.authorRepository = authorRepository;
        this.storyRepository = storyRepository;
    }

    public Author getByName(String name) {
        return authorRepository.findByName(name);
    }

    public List<Author> findAll() {
        List<Author> authors = authorRepository.findAll();

        for (Author author : authors) {
            int storiesCount = storyRepository.countByAuthors(author.getId());
            author.setStoriesCount(storiesCount);
        }

        return authors;
    }

    public Author findBySlug(String slug) {
        return authorRepository.findBySlug(slug);
    }

}
