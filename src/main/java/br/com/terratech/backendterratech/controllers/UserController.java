package br.com.terratech.backendterratech.controllers;

import br.com.terratech.backendterratech.entities.User;
import br.com.terratech.backendterratech.services.UserService;
import br.com.terratech.backendterratech.wrapper.Login;
import br.com.terratech.backendterratech.wrapper.RegisterUser;
import br.com.terratech.backendterratech.wrapper.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    try {
      List<User> users = userService.findAllUsers();
      return ResponseEntity.ok(users);
    } catch (Exception err) {
      return ResponseEntity.badRequest().build();
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<User>> findById(@PathVariable("id") String id){
    try{
      Optional<User> userExist = userService.findById(id);
      return ResponseEntity.ok(userExist);
    }catch (Exception err){
      return ResponseEntity.badRequest().build();
    }
  }

  @PostMapping("/register")
  public ResponseEntity<Object> create(@RequestBody RegisterUser user) {
    User created = userService.createUser(user);
    if (created != null) {
      return ResponseEntity.ok(user);
    } else {
      return ResponseEntity.badRequest().build();
    }

  }

  @PostMapping("/login")
  public ResponseEntity<Object> login(@RequestBody Login login) {
    Optional<User> userCpf = userService.loginUser(login);

    if (userCpf.isEmpty()) {
      return ResponseEntity.badRequest().body(new Response("Erro"));
    } else {
      return ResponseEntity.ok(userCpf);
    }
  }

  @PutMapping("/{cpf}")
  public ResponseEntity<String> update(@RequestBody User user, @PathVariable("cpf") String cpf) {
    try {
      userService.updateUser(cpf, user);
      return ResponseEntity.ok("Usuario atualizado");
    } catch (Exception err) {
      return ResponseEntity.internalServerError().build();
    }
  }

  @DeleteMapping("/{cpf}")
  public ResponseEntity<String> delete(@PathVariable("cpf") String cpf) {
    try {
      userService.deleteUser(cpf);
      return ResponseEntity.ok("Usuario removido");
    } catch (Exception err) {
      return ResponseEntity.internalServerError().build();
    }
  }
}
