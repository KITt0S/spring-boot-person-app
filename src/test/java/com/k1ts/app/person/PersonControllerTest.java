package com.k1ts.app.person;

import com.k1ts.app.person.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @Test
    public void addPerson() throws Exception {
        when(personService.addPerson("John", 25)).thenReturn("Person added: John, 25\n");
        mockMvc
                .perform(post("/person/add")
                        .param("name", "John")
                        .param("age", "25"))
                .andExpect(status().isOk())
                .andExpect(content().string("Person added: John, 25\n"));
    }

    @Test
    public void getPerson() throws Exception {
        when(personService.getPerson(0)).thenReturn("Person{id=0. name='Alice', age=18}\n");
        mockMvc
                .perform(get("/person/get")
                        .param("id", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("Person{id=0. name='Alice', age=18}\n"));
    }

    @Test
    public void updatePerson() throws Exception {
        when(personService.updatePerson(0, "John", 18)).thenReturn("Person{id=0, name='John', age=18}\n");
        mockMvc
                .perform(post("/person/update")
                        .param("id", "0")
                        .param("name", "John")
                        .param("age", "18"))
                .andExpect(status().isOk())
                .andExpect(content().string("Person{id=0, name='John', age=18}\n"));
    }

    @Test
    public void deletePerson() throws Exception {
        when(personService.deletePerson(0)).thenReturn("Person with id 0 is deleted successfully!\n");
        mockMvc
                .perform(delete("/person/delete")
                .param("id", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("Person with id 0 is deleted successfully!\n"));
    }

    @Test
    public void listPersons() throws Exception {
        when(personService.listPersons()).thenReturn("Person{id=0, name='John', age=18}\n");
        mockMvc
                .perform(get("/person/list"))
                .andExpect(status().isOk())
                .andExpect(content().string("Person{id=0, name='John', age=18}\n"));
    }
}