package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.model.Authorities;
import ru.netology.model.User;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class UserRepository {

  private final List<User> users = new CopyOnWriteArrayList<>();

  public List<Authorities> getUserAuthorities(User user) {
    int userIndex = users.indexOf(user);
    return userIndex != -1 ? users.get(userIndex).getAuthorities() : Collections.emptyList();
  }

  public String save(User user) {
    users.add(user);
    return user.getUser();
  }
}
