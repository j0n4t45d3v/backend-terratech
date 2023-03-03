package br.com.terratech.backendterratech.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Address")
public class Address {
    private String state;

    private String city;
    private String neighbourhood;
    @Id
    private String zipcode;

    private String number;

    private String street;



}
