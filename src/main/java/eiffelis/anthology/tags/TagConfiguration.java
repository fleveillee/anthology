package eiffelis.anthology.tags;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Order(value = 2)
@Configuration
public class TagConfiguration implements CommandLineRunner {
    private final TagRepository tagRepository;

    @Autowired
    public TagConfiguration(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public void run(String... args) {
        Tag tag1 = new Tag("Cool");
        Tag tag2 = new Tag("Technology");
        Tag tag3 = new Tag("Finance");
        Tag tag4 = new Tag("Sexy");
        Tag tag5 = new Tag("Apple");

        tagRepository.saveAll(List.of(tag1, tag2, tag3, tag4, tag5));
    }
}
