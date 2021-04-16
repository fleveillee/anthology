package eiffelis.anthology.stories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Order(value = 3)
@Configuration
public class StoryConfiguration implements CommandLineRunner {
    private final StoryRepository storyRepository;

    @Autowired
    public StoryConfiguration(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @Override
    public void run(String... args) {
        Story story1 = new Story(
                "The cows are MADD",
                "This is the story of mad cows flying around"
        );

        Story story2 = new Story(
                "The sheep are MADD",
                "This is the story of mad sheep flying around"
        );
        Story story3 = new Story(
                "The sheep are MADD; The Return",
                "This is the story of mad sheep flying around flying around"
        );
        Story story4 = new Story(
                "The flying sheep are MADD dosed",
                "This is the story of mad sheep flying around flying around flying around"
        );

        storyRepository.saveAll(List.of(story1, story2, story3, story4));
    }
}
