package eiffelis.anthology.authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getByName(String name) {
        return authorRepository.getByName(name).orElseThrow(() -> new NoSuchElementException("Author with name " + name + " could not be found."));
    }

}
