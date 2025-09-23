package com.k1ts.app.person.service;

import com.k1ts.app.person.pojo.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
