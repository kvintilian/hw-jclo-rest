package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.model.Authorities;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {
  public List<Authorities> getUserAuthorities(String user, String password) {
    // Easyway
    return "john".equals(user) && "doe".equals(password) ? Arrays.asList(Authorities.values()) : Collections.emptyList();
  }
}
