package webshop.dto;

import lombok.Data;
import webshop.entity.Category;

@Data
public class ProductDto {


    private String name;
    private double price;  // null või error kui db tühi koht!
    private Integer stock;
    private Boolean active;
    private String image;
    // @Column(name = "desc")
    private String description;

    private Category category;
}
