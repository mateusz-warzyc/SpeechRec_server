package pl.mateuszwarzyc.sr.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.mateuszwarzyc.sr.common.UserNotFoundException;
import pl.mateuszwarzyc.sr.controllers.BookmarkRestController;
import pl.mateuszwarzyc.sr.persistence.entities.Account;
import pl.mateuszwarzyc.sr.persistence.entities.Bookmark;
import pl.mateuszwarzyc.sr.persistence.repository.AccountRepository;
import pl.mateuszwarzyc.sr.persistence.repository.BookmarkRepository;

import java.util.Arrays;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "pl.mateuszwarzyc.sr.persistence.repository")
@EntityScan(basePackages = "pl.mateuszwarzyc.sr.persistence.entities")
@ComponentScan(basePackageClasses = {BookmarkRestController.class, UserNotFoundException.class})
public class SpeechRecServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpeechRecServerApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(AccountRepository accountRepository, BookmarkRepository bookmarkRepository) {
        return (evt) -> Arrays.asList("jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
                .forEach(a ->
        {
            Account account = accountRepository.save(new Account(a,
                    "password"));
            bookmarkRepository.save(new Bookmark(account,
                    "http://bookmark.com/1/" + a, "A description"));
            bookmarkRepository.save(new Bookmark(account,
                    "http://bookmark.com/2/" + a, "A description"));
        });
    }
}
