package eiffelis.anthology.stories;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Configuration
public class StoryConfig {

    @Bean
    CommandLineRunner commandLineRunner(StoryRepository storyRepository) {
        return args -> {
            Story story1 = new Story(
                    "The cows are MADD",
                    "This is the story of mad cows flying around",
                    "lorem ipsum dolor amet",
                    LocalDateTime.of(2001, Month.JANUARY, 1, 12, 2)
            );
            Story story2 = new Story(
                    "The sheep are MADD",
                    "This is the story of mad sheep flying around",
                    "lorem ipsum dolor amet due tres",
                    LocalDateTime.of(2011, Month.MARCH, 1, 13, 20)
            );
            storyRepository.saveAll(List.of(story1, story2));
        };
    }
}
