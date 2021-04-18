package eiffelis.anthology.chapters;

import eiffelis.anthology.authors.Author;
import eiffelis.anthology.authors.AuthorService;
import eiffelis.anthology.stories.Story;
import eiffelis.anthology.stories.StoryService;
import eiffelis.anthology.tags.Tag;
import eiffelis.anthology.tags.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;
import java.util.Set;

@Order(value = 4)
@Configuration
public class ChapterConfiguration implements CommandLineRunner {
    private final StoryService storyService;
    private final AuthorService authorService;
    private final TagService tagService;
    private final ChapterRepository chapterRepository;

    @Autowired
    public ChapterConfiguration(StoryService storyService, AuthorService authorService, TagService tagService, ChapterRepository chapterRepository) {
        this.storyService = storyService;
        this.authorService = authorService;
        this.tagService = tagService;
        this.chapterRepository = chapterRepository;
    }

    @Override
    public void run(String... args) {

        Tag tag1 = tagService.getTagByName("Sexy");
        Tag tag2 = tagService.getTagByName("Apple");

        Author author1 = authorService.getByName("Carmello");
        Author author2 = authorService.getByName("Giovanni");

        Story story1 = storyService.getStoryByTitle("The cows are MADD");
        Story story2 = storyService.getStoryByTitle("The flying sheep are MADD dosed");

        Chapter chapter1 = new Chapter(
                1,
                "Momma Say",
                "When Mooma say, you goota do",
                "MS Lorem ipsum dolor amet. Lorem ipsum dolor amet. Lorem ipsum dolor amet. Lorem ipsum dolor amet. Lorem ipsum dolor amet. ");

        chapter1.setStory(story1);
        chapter1.setAuthors(Set.of(author1));
        chapter1.setTags(Set.of(tag1, tag2));

        Chapter chapter2 = new Chapter(
                2,
                "Momma Say Some More",
                "When Mooma say more, you goota do more",
                "MSM Lorem ipsum dolor amet. Lorem ipsum dolor amet. Lorem ipsum dolor amet. Lorem ipsum dolor amet. Lorem ipsum dolor amet. ");

        chapter2.setStory(story1);
        chapter2.setAuthors(Set.of(author1));
        chapter2.setTags(Set.of(tag2));

        Chapter chapter3 = new Chapter(
                1,
                "Scooby Dooby",
                "Dooby Dooby DO! Lalalala.",
                "MS Lorem ipsum dolor amet. Lorem ipsum dolor amet. Lorem ipsum dolor amet. Lorem ipsum dolor amet. Lorem ipsum dolor amet. ");

        chapter3.setStory(story2);
        chapter3.setAuthors(Set.of(author2, author1));
        chapter3.setTags(Set.of(tag1));


        chapterRepository.saveAll(List.of(chapter1, chapter2, chapter3));

    }
}
