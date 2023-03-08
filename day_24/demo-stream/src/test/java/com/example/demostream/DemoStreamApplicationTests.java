package com.example.demostream;

import com.example.demostream.db.PersonDB;
import com.example.demostream.model.Person;
import com.example.demostream.repository.PersonRepository;
import com.example.demostream.repository.PersonRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoStreamApplicationTests {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void get_all_person() {
        List<Person> people = PersonDB.people;
        people.forEach(System.out::println);
    }

    @Test
    void groupPeopleByCity() {
        Map<String, List<Person>> rs =  personRepository.groupPeopleByCity();
        rs.entrySet().forEach(System.out::println);
    }
}
