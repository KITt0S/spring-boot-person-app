package com.k1ts.app.person;

import com.k1ts.app.person.service.PersonService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/person")
@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/test")
    public String test() {
        return "Hello from person controller\n";
    }

    @PostMapping("/add")
    public String addPerson(@RequestParam(name = "name") String name, @RequestParam(name = "age") int age) {
       return personService.addPerson(name, age);
    }

    @GetMapping("/get")
    public String getPerson(@RequestParam(name = "id") long id) {
        return personService.getPerson(id);
    }

    @PostMapping("/update")
    public String updatePerson(
            @RequestParam(name = "id") long id,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "age") int age) {
        return personService.updatePerson(id, name, age);
    }
}
