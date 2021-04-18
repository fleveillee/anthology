package eiffelis.anthology.tags;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag getTagByName(String name) {
        boolean exists = tagRepository.existsByName(name);

        if (!exists) {
            throw new NoSuchElementException("No Tag found named \"" + name + "\"");
        }

        return tagRepository.findByName(name).orElseThrow(() -> new NoSuchElementException("No Tag found named \"" + name + "\""));

    }


}
