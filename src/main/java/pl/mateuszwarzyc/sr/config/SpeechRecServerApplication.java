package pl.mateuszwarzyc.sr.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableConfigurationProperties
@EnableJpaRepositories(basePackages = {"pl.mateuszwarzyc.sr.persistence.repositories"})
@EntityScan(basePackages = "pl.mateuszwarzyc.sr.persistence.entities")
@ComponentScan(basePackages = "pl.mateuszwarzyc.sr.*")
public class SpeechRecServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpeechRecServerApplication.class, args);
    }
}
