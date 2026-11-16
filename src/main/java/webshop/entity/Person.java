package webshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter   // Lombok
@Setter
@AllArgsConstructor  // Küikide Arg. konstruktor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Long Andmetüüp 2,1miljardit
    private String firstName;
    private String lastName;

    @Column(unique = true)  // pärast sisselogmisel kasutada emaili frontis!!
    private String email;  //
    private String password;
    // Column unique = true , hetkel jätame selle lahtri tühjks (personalcode)
    private String personalCode;  //String = length == 11,       int > 100000000 && int < 9999999

    // kui lisan Personi siis saan aadressii kaasa , kui kustutan aaderssi siis kustub ka person!!!
    @OneToOne(cascade = CascadeType.ALL)

    private Aadress aadress;

    private PersonRole role;  /// Roll annab rollidele õigused! Seega Loome Enum KLASSI! ADMIN, CUSTOMER, PERSON
}
