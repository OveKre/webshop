package webshop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import webshop.entity.Product;

import java.util.List;

// CrudRepositroy --> standart/basic asju teha :salvestamine, kustutamine , võtmine , muutmine
//JPaRepository  --< võimaldab kõiki asju teha: tühjenda, kustuta kõik
// PagingAndSortingRepository -- võimaldab lehe külje kaupa vaadata ja sorteerida
public interface ProductRepository extends JpaRepository<Product, Long> {  // jpaRepostoryst tuleb ProductRepostorysse,funktsioonid mis tulevad anembaasist!


    List<Product> findByCategory_Id(Long id);
}
