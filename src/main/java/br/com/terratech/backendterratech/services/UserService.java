package br.com.terratech.backendterratech.services;

import br.com.terratech.backendterratech.entities.User;
import br.com.terratech.backendterratech.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

    public User createUser(User user) {
    if (
        user.getCpf() == null ||
        user.getName() == null ||
        user.getEmail() == null ||
        user.getPassword() == null ||
        user.getBirthDate() == null
    ) {
      return null;
    }
    return userRepository.save((user));
  }

  public List<User> findAllUsers() {
    return userRepository.findAll();
  }

  public void deleteUser(String cpf){
      userRepository.deleteById(cpf);
  }

  public void updateUser(String cpf){
      Optional<User> user = userRepository.findById(cpf);
  }
}
