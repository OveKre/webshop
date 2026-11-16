package webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webshop.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
