package eiffelis.anthology.stories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/stories")
public class StoryController {
    private final StoryService storyService;

    @Autowired
    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @GetMapping
    public String index(Model model) {
        List<Story> stories = storyService.getStories();
        model.addAttribute("stories", stories);
        return "stories/index";
    }

    @GetMapping("/{slug}")
    public String story(@PathVariable String slug, Model model) {
        Story story = storyService.getStoryBySlug(slug);
        model.addAttribute("story", story);
        return "stories/story";
    }

//    @PostMapping("/{slug}")
//    public String saveStory(@ModelAttribute Story story, Model model){
//
//    }


}
