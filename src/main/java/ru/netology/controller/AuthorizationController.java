package ru.netology.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.annotation.UserAnnotation;
import ru.netology.model.Authorities;
import ru.netology.model.User;
import ru.netology.service.AuthorizationService;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class AuthorizationController {
  final private AuthorizationService service;

  public AuthorizationController(AuthorizationService service) {
    this.service = service;
  }

  @GetMapping("/authorize")
  public ResponseEntity<List<Authorities>> getAuthorities(@Valid @UserAnnotation User user) {
    return ResponseEntity.ok(service.getAuthorities(user));
  }
}
