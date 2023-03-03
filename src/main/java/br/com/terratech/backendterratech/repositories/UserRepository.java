package br.com.terratech.backendterratech.repositories;

import br.com.terratech.backendterratech.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
}
