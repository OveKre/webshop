package webshop.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webshop.dto.ProductDto;
import webshop.entity.Product;
import webshop.repository.CategoryRepository;
import webshop.repository.ProductRepository;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173") /// Turvalisuse küsimus - kelle ma enda rakendusele ligi laseme(siin puhul frontend -CORS nõue)
@RestController
@RequiredArgsConstructor
// @AllArgsConstructor  // tekib konflikt int , Date tüüpidega
public class ProductController {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    // Selle asmele teeme annotatsiooni kaud (Lombok)
    // public ProductController(ProductRepository productRepository) {
   //     this.productRepository = productRepository;
    //}

    /// @Autowired // tümbab sisse selle klassi!!



    @GetMapping("products") // localhost:7070/products
    public List<Product> getProducts(@RequestParam(required = false) Long categoryId) {
        if (categoryId == null || categoryId == 0) {
            return productRepository.findAll();
        } else {
            return productRepository.findByCategory_Id(categoryId);
        }
        // Leia kõik andmebaasist | SELECT * From Products; (ProductRepositoryist!!
    }

    @PostMapping("products")
    public Product addProduct(@RequestBody ProductDto productDto) {
        if (productDto.getName() == null || productDto.getName().isBlank()) {
            throw new RuntimeException("Product must have name");
        }
        if (productDto.getPrice() < 0) {
            throw new RuntimeException("Product price cannot be negative");
        }
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setDescription(productDto.getDescription());
        product.setActive(productDto.getActive());
        product.setImage(productDto.getImage());
        product.setCategory(productDto.getCategory());

        return productRepository.save(product);  // INSERT INTO products  --
    }

    @PutMapping("products")
    public Product editProduct(@RequestBody Product product) {
        if (product.getId() == null || product.getId() <= 0) {
            throw new RuntimeException("Product must have id");
        }
        if (product.getName() == null || product.getName().isBlank()) {
            throw new RuntimeException("Product must have name");
        }
        if (product.getPrice() < 0) {
            throw new RuntimeException("Product price cannot be negative");
        }
        return productRepository.save(product);  // INSERT INTO products  --
    }
    @DeleteMapping("products/{id}")
    public List<Product> deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return productRepository.findAll();
    }
}




// http://localhost:8080/swagger-ui/index.html




