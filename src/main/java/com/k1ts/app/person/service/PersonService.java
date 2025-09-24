package com.k1ts.app.person.service;

import com.k1ts.app.person.pojo.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
                .orElse("Person with id " + id + " is not found...\n");
    }

    public String updatePerson(long id, String name, int age) {
        Optional<Person> optionalPerson = persons
                .stream()
                .filter(person -> person.getId() == id)
                .findFirst();

        if (optionalPerson.isEmpty()) {
            return "Person with id " + id + " is not found...\n";
        }

        Person person = optionalPerson.get();

        person.setName(name);
        person.setAge(age);

        return person.toString() + "\n";
    }

    public String deletePerson(long id) {
        Optional<Person> optionalPerson = persons
                .stream()
                .filter(person -> person.getId() == id)
                .findFirst();

        if (optionalPerson.isEmpty()) {
            return "Person with id " + id + " is not found...\n";
        }

        persons.removeIf(person -> person.getId() == id);

        return "Person with " + id + " is deleted successfully!\n";
    }

    public String listPersons() {
        if (persons.isEmpty()) {
            return "Person database is empty...\n";
        }

        return persons
                .stream()
                .map(Person::toString)
                .collect(Collectors.joining("\n")) + "\n";
    }
}
