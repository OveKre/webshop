package webshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter   // Lombok
@Setter
@AllArgsConstructor  // Küikide Arg. konstruktor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Long Andmetüüp 2,1miljardit

    @ManyToOne
    private Person person; // Kes tellis toote

    @ManyToMany // ühel tellimsussel on mitu toodet  AGA üks toode võib olla mitmes tellimuses!!
    private List<Product> products; // Toodete ostukorvi list

    private Date created;  // Mis ajal loodud ostukorv

    private double sum; /// Mis ostukorvi summa on

    private PaymentState state;    // Mis seisu makse on!!
 }
