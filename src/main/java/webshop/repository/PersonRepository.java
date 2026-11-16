package webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webshop.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
