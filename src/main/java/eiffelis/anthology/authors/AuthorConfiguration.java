package eiffelis.anthology.authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Order(value = 1)
@Configuration
public class AuthorConfiguration implements CommandLineRunner {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorConfiguration(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) {
        Author author1 = new Author("Carmello");
        Author author2 = new Author("Giovanni");
        Author author3 = new Author("Beluga");
        Author author4 = new Author("Somofit");

        authorRepository.saveAll(List.of(author1, author2, author3, author4));
    }
}
