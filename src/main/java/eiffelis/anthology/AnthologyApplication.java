package eiffelis.anthology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // Used to enable @CreatedDate and @LastModifiedDate fields in BaseEntity
public class AnthologyApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnthologyApplication.class, args);
    }

}
