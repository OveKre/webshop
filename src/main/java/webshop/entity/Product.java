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
@Entity // <--- Siit saab meie rakendus teada
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Long Andmetüüp 2,1miljardit
    private String name;
    private double price;  // null või error kui db tühi koht!
    private Integer stock;
    private Boolean active;
    private String image;
    // @Column(name = "desc")
    private String description;

        @ManyToOne // --> igal tootel on täpselt üks katgooria , aga kategoorial võib olla mitmeid tooteid!
    private Category category;
}
