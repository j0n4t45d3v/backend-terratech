package br.com.terratech.backendterratech.controllers;

import br.com.terratech.backendterratech.entities.User;
import br.com.terratech.backendterratech.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping
  public ResponseEntity<List<User>> findAll(){
    List<User> users = userService.findAllUsers();
    return ResponseEntity.ok(users);
  }

}
