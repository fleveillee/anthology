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

        Tag tag1 = tagService.findOneByName("Sexy");
        Tag tag2 = tagService.findOneByName("Apple");

        Author author1 = authorService.getByName("Carmello");
        Author author2 = authorService.getByName("Giovanni");
        Author author3 = authorService.getByName("Beluga");

        Story story1 = storyService.getStoryByTitle("The cows are MADD");
        Story story2 = storyService.getStoryByTitle("The flying sheep are MADD dosed");

        Chapter chapter1 = new Chapter(
                1,
                "Momma Say",
                "When Mooma say, you goota do",
                """
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pellentesque habitant morbi tristique senectus et netus et. Cursus metus aliquam eleifend mi in nulla posuere sollicitudin. Auctor urna nunc id cursus metus aliquam eleifend mi in. Sed libero enim sed faucibus turpis in. Id venenatis a condimentum vitae sapien pellentesque habitant morbi. Dolor sit amet consectetur adipiscing. Augue mauris augue neque gravida in fermentum. Mattis pellentesque id nibh tortor id aliquet lectus. Turpis egestas maecenas pharetra convallis. Quis viverra nibh cras pulvinar mattis nunc sed blandit. Maecenas ultricies mi eget mauris pharetra et. Fames ac turpis egestas maecenas pharetra convallis posuere. Dictumst vestibulum rhoncus est pellentesque. Arcu non sodales neque sodales ut. Vestibulum lectus mauris ultrices eros in cursus turpis massa tincidunt. Faucibus pulvinar elementum integer enim neque volutpat ac tincidunt.

                Id neque aliquam vestibulum morbi blandit cursus risus at. Nec ultrices dui sapien eget mi proin sed libero. Ac ut consequat semper viverra nam. Sed turpis tincidunt id aliquet risus. Duis at consectetur lorem donec massa sapien faucibus et molestie. Tortor consequat id porta nibh venenatis cras. Sagittis orci a scelerisque purus semper eget. Etiam dignissim diam quis enim lobortis. Et malesuada fames ac turpis egestas sed. Faucibus vitae aliquet nec ullamcorper sit amet risus nullam.

                Id faucibus nisl tincidunt eget nullam non nisi est sit. Ornare quam viverra orci sagittis eu volutpat odio facilisis. Lorem sed risus ultricies tristique nulla aliquet enim tortor. Suspendisse interdum consectetur libero id faucibus nisl tincidunt eget. At quis risus sed vulputate odio ut enim. Ornare arcu dui vivamus arcu felis bibendum ut tristique. Vivamus arcu felis bibendum ut tristique et egestas quis ipsum. Elementum nisi quis eleifend quam. Nibh sit amet commodo nulla facilisi nullam vehicula. Vitae congue mauris rhoncus aenean. Ullamcorper dignissim cras tincidunt lobortis feugiat vivamus at augue eget. Etiam dignissim diam quis enim lobortis scelerisque fermentum dui. Laoreet sit amet cursus sit amet.

                Pellentesque diam volutpat commodo sed egestas egestas fringilla phasellus. Eu consequat ac felis donec et odio pellentesque. Mattis enim ut tellus elementum sagittis vitae. Nunc id cursus metus aliquam eleifend mi in. Volutpat est velit egestas dui id. Rhoncus mattis rhoncus urna neque viverra justo. Nunc aliquet bibendum enim facilisis gravida neque convallis a. Tincidunt praesent semper feugiat nibh sed pulvinar proin. Purus faucibus ornare suspendisse sed nisi lacus sed. Eu feugiat pretium nibh ipsum consequat. Enim nec dui nunc mattis enim ut. Massa massa ultricies mi quis hendrerit dolor magna. Scelerisque eu ultrices vitae auctor eu augue. Tempus iaculis urna id volutpat. Aliquam malesuada bibendum arcu vitae. Vitae turpis massa sed elementum tempus egestas.

                Quisque id diam vel quam elementum pulvinar etiam non. Fusce id velit ut tortor pretium viverra suspendisse potenti. Quam quisque id diam vel quam elementum. Dolor sit amet consectetur adipiscing elit duis tristique sollicitudin. Nisi scelerisque eu ultrices vitae auctor. Tristique nulla aliquet enim tortor at auctor urna. Blandit cursus risus at ultrices. Mattis enim ut tellus elementum sagittis vitae et. Nisi vitae suscipit tellus mauris a diam maecenas sed. Malesuada pellentesque elit eget gravida cum sociis natoque.""");

        chapter1.setStory(story1);
        chapter1.setAuthors(Set.of(author1));
        chapter1.setTags(Set.of(tag1, tag2));

        Chapter chapter2 = new Chapter(
                2,
                "Momma Say Some More",
                "When Mooma say more, you goota do more",
                """
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pellentesque habitant morbi tristique senectus et netus et. Cursus metus aliquam eleifend mi in nulla posuere sollicitudin. Auctor urna nunc id cursus metus aliquam eleifend mi in. Sed libero enim sed faucibus turpis in. Id venenatis a condimentum vitae sapien pellentesque habitant morbi. Dolor sit amet consectetur adipiscing. Augue mauris augue neque gravida in fermentum. Mattis pellentesque id nibh tortor id aliquet lectus. Turpis egestas maecenas pharetra convallis. Quis viverra nibh cras pulvinar mattis nunc sed blandit. Maecenas ultricies mi eget mauris pharetra et. Fames ac turpis egestas maecenas pharetra convallis posuere. Dictumst vestibulum rhoncus est pellentesque. Arcu non sodales neque sodales ut. Vestibulum lectus mauris ultrices eros in cursus turpis massa tincidunt. Faucibus pulvinar elementum integer enim neque volutpat ac tincidunt.

                Id neque aliquam vestibulum morbi blandit cursus risus at. Nec ultrices dui sapien eget mi proin sed libero. Ac ut consequat semper viverra nam. Sed turpis tincidunt id aliquet risus. Duis at consectetur lorem donec massa sapien faucibus et molestie. Tortor consequat id porta nibh venenatis cras. Sagittis orci a scelerisque purus semper eget. Etiam dignissim diam quis enim lobortis. Et malesuada fames ac turpis egestas sed. Faucibus vitae aliquet nec ullamcorper sit amet risus nullam.

                Id faucibus nisl tincidunt eget nullam non nisi est sit. Ornare quam viverra orci sagittis eu volutpat odio facilisis. Lorem sed risus ultricies tristique nulla aliquet enim tortor. Suspendisse interdum consectetur libero id faucibus nisl tincidunt eget. At quis risus sed vulputate odio ut enim. Ornare arcu dui vivamus arcu felis bibendum ut tristique. Vivamus arcu felis bibendum ut tristique et egestas quis ipsum. Elementum nisi quis eleifend quam. Nibh sit amet commodo nulla facilisi nullam vehicula. Vitae congue mauris rhoncus aenean. Ullamcorper dignissim cras tincidunt lobortis feugiat vivamus at augue eget. Etiam dignissim diam quis enim lobortis scelerisque fermentum dui. Laoreet sit amet cursus sit amet.

                Pellentesque diam volutpat commodo sed egestas egestas fringilla phasellus. Eu consequat ac felis donec et odio pellentesque. Mattis enim ut tellus elementum sagittis vitae. Nunc id cursus metus aliquam eleifend mi in. Volutpat est velit egestas dui id. Rhoncus mattis rhoncus urna neque viverra justo. Nunc aliquet bibendum enim facilisis gravida neque convallis a. Tincidunt praesent semper feugiat nibh sed pulvinar proin. Purus faucibus ornare suspendisse sed nisi lacus sed. Eu feugiat pretium nibh ipsum consequat. Enim nec dui nunc mattis enim ut. Massa massa ultricies mi quis hendrerit dolor magna. Scelerisque eu ultrices vitae auctor eu augue. Tempus iaculis urna id volutpat. Aliquam malesuada bibendum arcu vitae. Vitae turpis massa sed elementum tempus egestas.

                Quisque id diam vel quam elementum pulvinar etiam non. Fusce id velit ut tortor pretium viverra suspendisse potenti. Quam quisque id diam vel quam elementum. Dolor sit amet consectetur adipiscing elit duis tristique sollicitudin. Nisi scelerisque eu ultrices vitae auctor. Tristique nulla aliquet enim tortor at auctor urna. Blandit cursus risus at ultrices. Mattis enim ut tellus elementum sagittis vitae et. Nisi vitae suscipit tellus mauris a diam maecenas sed. Malesuada pellentesque elit eget gravida cum sociis natoque.""");

        chapter2.setStory(story1);
        chapter2.setAuthors(Set.of(author2));
        chapter2.setTags(Set.of(tag2));

        Chapter chapter3 = new Chapter(
                1,
                "Scooby Dooby",
                "Dooby Dooby DO! Lalalala.",
                """
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pellentesque habitant morbi tristique senectus et netus et. Cursus metus aliquam eleifend mi in nulla posuere sollicitudin. Auctor urna nunc id cursus metus aliquam eleifend mi in. Sed libero enim sed faucibus turpis in. Id venenatis a condimentum vitae sapien pellentesque habitant morbi. Dolor sit amet consectetur adipiscing. Augue mauris augue neque gravida in fermentum. Mattis pellentesque id nibh tortor id aliquet lectus. Turpis egestas maecenas pharetra convallis. Quis viverra nibh cras pulvinar mattis nunc sed blandit. Maecenas ultricies mi eget mauris pharetra et. Fames ac turpis egestas maecenas pharetra convallis posuere. Dictumst vestibulum rhoncus est pellentesque. Arcu non sodales neque sodales ut. Vestibulum lectus mauris ultrices eros in cursus turpis massa tincidunt. Faucibus pulvinar elementum integer enim neque volutpat ac tincidunt.

                Id neque aliquam vestibulum morbi blandit cursus risus at. Nec ultrices dui sapien eget mi proin sed libero. Ac ut consequat semper viverra nam. Sed turpis tincidunt id aliquet risus. Duis at consectetur lorem donec massa sapien faucibus et molestie. Tortor consequat id porta nibh venenatis cras. Sagittis orci a scelerisque purus semper eget. Etiam dignissim diam quis enim lobortis. Et malesuada fames ac turpis egestas sed. Faucibus vitae aliquet nec ullamcorper sit amet risus nullam.

                Id faucibus nisl tincidunt eget nullam non nisi est sit. Ornare quam viverra orci sagittis eu volutpat odio facilisis. Lorem sed risus ultricies tristique nulla aliquet enim tortor. Suspendisse interdum consectetur libero id faucibus nisl tincidunt eget. At quis risus sed vulputate odio ut enim. Ornare arcu dui vivamus arcu felis bibendum ut tristique. Vivamus arcu felis bibendum ut tristique et egestas quis ipsum. Elementum nisi quis eleifend quam. Nibh sit amet commodo nulla facilisi nullam vehicula. Vitae congue mauris rhoncus aenean. Ullamcorper dignissim cras tincidunt lobortis feugiat vivamus at augue eget. Etiam dignissim diam quis enim lobortis scelerisque fermentum dui. Laoreet sit amet cursus sit amet.

                Pellentesque diam volutpat commodo sed egestas egestas fringilla phasellus. Eu consequat ac felis donec et odio pellentesque. Mattis enim ut tellus elementum sagittis vitae. Nunc id cursus metus aliquam eleifend mi in. Volutpat est velit egestas dui id. Rhoncus mattis rhoncus urna neque viverra justo. Nunc aliquet bibendum enim facilisis gravida neque convallis a. Tincidunt praesent semper feugiat nibh sed pulvinar proin. Purus faucibus ornare suspendisse sed nisi lacus sed. Eu feugiat pretium nibh ipsum consequat. Enim nec dui nunc mattis enim ut. Massa massa ultricies mi quis hendrerit dolor magna. Scelerisque eu ultrices vitae auctor eu augue. Tempus iaculis urna id volutpat. Aliquam malesuada bibendum arcu vitae. Vitae turpis massa sed elementum tempus egestas.

                Quisque id diam vel quam elementum pulvinar etiam non. Fusce id velit ut tortor pretium viverra suspendisse potenti. Quam quisque id diam vel quam elementum. Dolor sit amet consectetur adipiscing elit duis tristique sollicitudin. Nisi scelerisque eu ultrices vitae auctor. Tristique nulla aliquet enim tortor at auctor urna. Blandit cursus risus at ultrices. Mattis enim ut tellus elementum sagittis vitae et. Nisi vitae suscipit tellus mauris a diam maecenas sed. Malesuada pellentesque elit eget gravida cum sociis natoque.""");

        chapter3.setStory(story2);
        chapter3.setAuthors(Set.of(author2, author3));
        chapter3.setTags(Set.of(tag1));


        chapterRepository.saveAll(List.of(chapter1, chapter2, chapter3));

    }
}
