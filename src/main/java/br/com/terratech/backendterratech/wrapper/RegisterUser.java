package br.com.terratech.backendterratech.wrapper;

import br.com.terratech.backendterratech.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUser {
    private String cpf;

    private String name;

    private String email;

    private String password;

    private String confirmPassword;

    private LocalDate birthDate;

    private Address address;
}
