package com.k1ts.app.person.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonServiceTest {

    private PersonService personService;

    @Before
    public void setUp() {
        personService = new PersonService();
    }

    @Test
    public void addPerson() {
        String result = personService.addPerson("John", 25);
        Assert.assertTrue(result.contains("John"));
        Assert.assertTrue(result.contains("25"));
    }

    @Test
    public void getPerson() {
        personService.addPerson("Alice", 35);
        String result = personService.getPerson(0);
        Assert.assertTrue(result.contains("Alice"));
        Assert.assertTrue(result.contains("35"));
    }

    @Test
    public void getPersonWithNonExistentId() {
        String result = personService.getPerson(0);
        Assert.assertEquals("Person with id 0 is not found...\n", result);
    }

    @Test
    public void updatePerson() {
        personService.addPerson("Alice", 35);
        String result = personService.updatePerson(0, "Michael", 30);
        Assert.assertTrue(result.contains("Michael"));
        Assert.assertTrue(result.contains("30"));
    }

    @Test
    public void updatePersonWithNonExistentId() {
        String result = personService.updatePerson(0, "Michael", 30);
        Assert.assertEquals("Person with id 0 is not found...\n", result);
    }

    @Test
    public void deletePerson() {
        personService.addPerson("Alice", 35);
        String result = personService.deletePerson(0);
        Assert.assertEquals("Person with id 0 is deleted successfully!\n", result);
    }

    @Test
    public void deletePersonWithNonExistentId() {
        String result = personService.deletePerson(0);
        Assert.assertEquals("Person with id 0 is not found...\n", result);
    }

    @Test
    public void listPersons() {
        personService.addPerson("John", 25);
        personService.addPerson("Alice", 35);
        String result = personService.listPersons();
        Assert.assertTrue(result.contains("John"));
        Assert.assertTrue(result.contains("25"));
        Assert.assertTrue(result.contains("Alice"));
        Assert.assertTrue(result.contains("35"));
    }
}