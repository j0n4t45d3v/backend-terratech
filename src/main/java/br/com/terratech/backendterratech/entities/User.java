package br.com.terratech.backendterratech.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;


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

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate birthDate;

  @OneToOne()
  @JoinColumn(name = "zipcode", nullable = false)
  private Address address;

  @OneToMany
  private List<Product> products;

}
