package webshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter   // Lombok
@Setter
@AllArgsConstructor  // Küikide Arg. konstruktor
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Long Andmetüüp 2,1miljardit
    private String name;

    @OneToMany
    private List<Product> products;
}
