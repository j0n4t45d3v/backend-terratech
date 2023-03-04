package br.com.terratech.backendterratech.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {
  @Id
  private String zipcode;
  private String state;
  private String city;
  private String neighbourhood;
  private String number;
  private String street;

}
