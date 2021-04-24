package eiffelis.anthology.tags;

import eiffelis.anthology.stories.Story;
import eiffelis.anthology.stories.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/tags")
public class TagController {

    private final StoryService storyService;
    private final TagService tagService;

    @Autowired
    public TagController(StoryService storyService, TagService tagService) {
        this.storyService = storyService;
        this.tagService = tagService;
    }

    @GetMapping
    public String list(Model model) {
        List<Tag> tags = tagService.findAll();
        model.addAttribute("tags", tags);
        return "tags/list";
    }

    @GetMapping("/{slug}")
    public String view(@PathVariable String slug, Model model) {
        Tag tag = tagService.findOneBySlug(slug);
        Set<Story> stories = storyService.findByTag(tag);
        model.addAttribute("tag", tag);
        model.addAttribute("stories", stories);

        return "tags/view";
    }
}
