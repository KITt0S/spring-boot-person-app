package com.k1ts.app.person.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonServiceTest {

    private PersonService personService;

    @BeforeEach
    public void setUp() {
        personService = new PersonService();
    }

    @Test
    public void addPerson() {
        String result = personService.addPerson("John", 25);
        Assertions.assertTrue(result.contains("John"));
        Assertions.assertTrue(result.contains("25"));
    }

    @Test
    public void getPerson() {
        personService.addPerson("Alice", 35);
        String result = personService.getPerson(0);
        Assertions.assertTrue(result.contains("Alice"));
        Assertions.assertTrue(result.contains("35"));
    }

    @Test
    public void getPersonWithNonExistentId() {
        String result = personService.getPerson(0);
        Assertions.assertEquals("Person with id 0 is not found...\n", result);
    }

    @Test
    public void updatePerson() {
        personService.addPerson("Alice", 35);
        String result = personService.updatePerson(0, "Michael", 30);
        Assertions.assertTrue(result.contains("Michael"));
        Assertions.assertTrue(result.contains("30"));
    }

    @Test
    public void updatePersonWithNonExistentId() {
        String result = personService.updatePerson(0, "Michael", 30);
        Assertions.assertEquals("Person with id 0 is not found...\n", result);
    }

    @Test
    public void deletePerson() {
        personService.addPerson("Alice", 35);
        String result = personService.deletePerson(0);
        Assertions.assertEquals("Person with id 0 is deleted successfully!\n", result);
    }

    @Test
    public void deletePersonWithNonExistentId() {
        String result = personService.deletePerson(0);
        Assertions.assertEquals("Person with id 0 is not found...\n", result);
    }

    @Test
    public void listPersons() {
        personService.addPerson("John", 25);
        personService.addPerson("Alice", 35);
        String result = personService.listPersons();
        Assertions.assertTrue(result.contains("John"));
        Assertions.assertTrue(result.contains("25"));
        Assertions.assertTrue(result.contains("Alice"));
        Assertions.assertTrue(result.contains("35"));
    }
}