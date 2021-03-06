package eiffelis.anthology.authors;

import eiffelis.anthology.stories.Story;
import eiffelis.anthology.stories.StoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;
    private final StoryService storyService;

    public AuthorController(AuthorService authorService, StoryService storyService) {
        this.authorService = authorService;
        this.storyService = storyService;
    }

    @GetMapping
    public String list(Model model) {
        List<Author> authors = authorService.findAll();
        model.addAttribute("authors", authors);
        return "authors/list";
    }

    @GetMapping("/{slug}")
    public String view(@PathVariable String slug, Model model) {
        Author author = authorService.findBySlug(slug);
        Set<Story> stories = storyService.findByAuthor(author);
        model.addAttribute("author", author);

        model.addAttribute("stories", stories);
        return "authors/view";
    }
}
