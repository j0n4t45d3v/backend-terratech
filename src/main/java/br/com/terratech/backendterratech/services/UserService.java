package br.com.terratech.backendterratech.services;

import br.com.terratech.backendterratech.repositories.AddressRepository;
import br.com.terratech.backendterratech.wrapper.Login;
import br.com.terratech.backendterratech.entities.User;
import br.com.terratech.backendterratech.repositories.UserRepository;
import br.com.terratech.backendterratech.wrapper.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private AddressRepository addressRepository;
//  @Autowired
//  private PasswordEncoder crypto;

  public Optional<User> loginUser(Login login) {
    Optional<User> userExist = userRepository.findByEmail(login.getEmail());
    if (userExist.isPresent()) {
//      if (crypto.matches(login.getPassword(), userExist.get().getPassword())) {
//
//      }
      return userExist;
    }
    return Optional.empty();
  }

  public User createUser(RegisterUser user) {
    Optional<User> userExit = userRepository.findById(user.getCpf()); // procura o usuario no banco optional serve para caso o usuario seja nulo

    if (
            userExit.isEmpty() && // verifica se o usuario não existe
                    !user.getCpf().isEmpty() &&
                    !user.getName().isEmpty() &&
                    !user.getEmail().isEmpty() &&
                    !user.getPassword().isEmpty() &&
                    user.getBirthDate() != null &&
                    user.getAddress() != null  &&
                    user.getPassword().equals(user.getConfirmPassword())
    ) {

      addressRepository.save(user.getAddress());

      User register = new User(user.getCpf(), user.getName(), user.getEmail(), user.getPassword(), user.getBirthDate(), user.getAddress());

//      user.setPassword(crypto.encode(user.getPassword()));
      return userRepository.save(register);
    }
    return null;
  }

  public List<User> findAllUsers() {
    return userRepository.findAll();
  }
  public Optional<User> findById(String id){
    return  userRepository.findById(id);
  }

  public void deleteUser(String cpf) throws Exception {
    Optional<User> userExist = userRepository.findById(cpf);

    if (userExist.isPresent()) {
      userRepository.deleteById(cpf);
    } else {
      throw new Exception("Usuario não encontrado");
    }
  }

  public void updateUser(String cpf, User updateUser) throws Exception {
    Optional<User> userExist = userRepository.findById(cpf);

    if (userExist.isPresent()) {
      User user = userExist.get();
      if (updateUser.getName() != null) {
        user.setName(updateUser.getName());
      }
      if (updateUser.getEmail() != null) {
        user.setEmail(updateUser.getEmail());
      }
      if (updateUser.getPassword() != null) {
        user.setPassword(updateUser.getPassword());
      }
      if (updateUser.getAddress() != null) {
        user.setAddress(updateUser.getAddress());
      }
      userRepository.save(user);
    } else {
      throw new Exception("usuario não encontrado");
    }
  }
}
