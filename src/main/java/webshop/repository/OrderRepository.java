package webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webshop.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
