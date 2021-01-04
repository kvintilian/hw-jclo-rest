package ru.netology.service;

import org.springframework.stereotype.Service;
import ru.netology.exception.InvalidCredentials;
import ru.netology.exception.UnauthorizedUser;
import ru.netology.model.Authorities;
import ru.netology.model.User;
import ru.netology.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
  final private UserRepository userRepository;

  public AuthorizationService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<Authorities> getAuthorities(User user) {
    if (isEmpty(user.getUser()) || isEmpty(user.getPassword())) {
      throw new InvalidCredentials("User name or password is empty");
    }
    List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
    if (isEmpty(userAuthorities)) {
      throw new UnauthorizedUser("Unknown user " + user.getUser());
    }
    return userAuthorities;
  }

  private boolean isEmpty(String str) {
    return str == null || str.isEmpty();
  }

  private boolean isEmpty(List<?> str) {
    return str == null || str.isEmpty();
  }
}
