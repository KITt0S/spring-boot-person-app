package com.k1ts.app.person.service;

import com.k1ts.app.person.pojo.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final List<Person> persons = new ArrayList<>();

    public String addPerson(String name, int age) {
        Person person = new Person(name, age);
        persons.add(person);
        return person.toString() + "\n";
    }

    public String getPerson(long id) {
        return persons
                .stream()
                .filter(person -> person.getId() == id)
                .map(person -> person.toString() + "\n")
                .findFirst()
                .orElse("Person with id " + id + " is not found..." + "\n");
    }

    public String updatePerson(long id, String name, int age) {
        Optional<Person> optionalPerson = persons
                .stream()
                .filter(person -> person.getId() == id)
                .findFirst();

        if (optionalPerson.isEmpty()) {
            return "Person with id " + id + " is not found..." + "\n";
        }

        Person person = optionalPerson.get();

        person.setName(name);
        person.setAge(age);

        return person.toString();
    }
}
