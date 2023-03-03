package br.com.terratech.backendterratech.services;

import br.com.terratech.backendterratech.entities.User;
import br.com.terratech.backendterratech.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public User createUser(User user) {
    return userRepository.save((user));
  }

  public List<User> findAllUsers() {
    return userRepository.findAll();
  }
}
