package com.example.sbsecur;

import com.example.sbsecur.model.Person;
import com.example.sbsecur.person.PersonRepositoryCSV;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SbsecurApplicationTests {



    @Test
    void get_all_person() {
        List<Person> people = personRepositoryCSV.getAll();
        personRepositoryCSV.printListPeople(people);
    }
}
