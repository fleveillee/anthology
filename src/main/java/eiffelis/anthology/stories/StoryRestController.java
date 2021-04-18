package eiffelis.anthology.stories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
public class StoryRestController {
    private final StoryService storyService;

    @Autowired
    public StoryRestController(StoryService storyService) {
        this.storyService = storyService;
    }

    @PostMapping
    public void saveStory(@RequestBody Story story) {
        storyService.addStory(story);
    }

    @PutMapping("/{storyId}")
    public void updateStory(
            @PathVariable("storyId") UUID id,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String summary,
            @RequestParam(required = false) String content,
            @RequestParam(required = false) LocalDateTime publicationDate
    ) {
        storyService.updateStory(id, title, summary);
    }

    @DeleteMapping(path = "/{storyId}")
    public void deleteStory(@PathVariable("storyId") UUID id) {
        try {
            storyService.archiveStory(id);
        } catch (OperationNotSupportedException exception) {
            // TODO handle exception
        }
    }

}
