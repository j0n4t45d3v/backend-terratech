package br.com.terratech.backendterratech.repositories;

import br.com.terratech.backendterratech.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {
}
