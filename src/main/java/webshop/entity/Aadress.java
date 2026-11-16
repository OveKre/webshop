package webshop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter   // Lombok
@Setter
@AllArgsConstructor  // Küikide Arg. konstruktor
@NoArgsConstructor
@Entity
public class Aadress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Long Andmetüüp 2,1miljardit
    private String street;
    private String streetNumber;
    private String city;
    private String postalIndex;
    private String county;
    private String country;


}



