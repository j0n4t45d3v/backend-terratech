package br.com.terratech.backendterratech.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

  @Id
  @Column(unique = true, nullable = false)
  private String cpf;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String birthDate;
  @OneToOne()
  @JoinColumn(name = "zipcode")
  private Address address;


}
