package ru.netology.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.model.Authorities;
import ru.netology.model.User;
import ru.netology.repository.UserRepository;

import java.util.Arrays;

@Configuration
public class LoadUsers {

  private static final Logger log = LoggerFactory.getLogger(LoadUsers.class);

  @Bean
  public CommandLineRunner initUsers(UserRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new User("john", "doe", Arrays.asList(Authorities.values()))));
      log.info("Preloading " + repository.save(new User("vasiliy", "pupkin", Arrays.asList(Authorities.READ, Authorities.WRITE))));
    };
  }
}
