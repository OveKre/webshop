package webshop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webshop.entity.Category;
import webshop.repository.CategoryRepository;

import java.util.List;
@Log4j2
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173") /// Turvalisuse küsimus - kelle ma enda rakendusele ligi laseme(siin puhul frontend -CORS nõue)

public class CategoryController { /// Siin andsime staatuksoodi muutmise võimekuse, KUID PÄRIAprojektis tuleks teha seda igas CONTROLLERIS THEA

    private final CategoryRepository categoryRepository;

    @GetMapping("categories")
    public ResponseEntity<List<Category>> getCategories() {
        log.info("Categories GET request made by: xx");   /// LOG4j2 annotats. ja log.info lisamine funktsiooni sisse!
        /// RESPONSEENTITY saab staatus koode lisada!!!
        return ResponseEntity.ok(categoryRepository.findAll());
    }

    @PostMapping("categories")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        if (category.getId() != null) {
            throw new RuntimeException("when adding category, cannot add id");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryRepository.save(category));
    }

    @DeleteMapping("categories/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
