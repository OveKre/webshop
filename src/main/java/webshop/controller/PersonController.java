package webshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import webshop.entity.Person;
import webshop.repository.PersonRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonController {
     private final PersonRepository personRepository;

     @GetMapping("person")
    public List<Person> getPerson() {
         return personRepository.findAll();
     }
    @PostMapping("signup")
    public String signup(@RequestBody Person person) {
         personRepository.save(person);
         return "Eduaklt registreeritud";
     }
     @PostMapping("login")
    public String login(@RequestBody Person person) {
        return "Eduaklt Sisse logitud";
    }
}
