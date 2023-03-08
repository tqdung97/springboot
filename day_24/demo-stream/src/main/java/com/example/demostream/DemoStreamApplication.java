package com.example.demostream;

import com.example.demostream.db.PersonDB;
import com.example.demostream.model.Person;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.FileReader;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoStreamApplication.class, args);
    }

    @Autowired
    private ResourceLoader resourceLoader;

    @Bean
    public CommandLineRunner initializeData() {
        return args -> {
            PersonDB.people = readCsv("person.csv");
        };
    }

    public List<Person> readCsv(String filename) {
        try {
            Resource resource = resourceLoader.getResource("classpath:static/" + filename);
            Reader reader = new FileReader(resource.getFile());
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

            List<String[]> rows = csvReader.readAll();
            List<Person> people = new ArrayList<>();

            for (String[] row : rows) {
                Person person = new Person();
                person.setId(Integer.valueOf(row[0]));
                person.setFullName(row[1]);
                person.setJob(row[2]);
                person.setGender(row[3]);
                person.setCity(row[4]);
                person.setSalary(Integer.valueOf(row[5]));
                person.setBirthday(row[6]);
                people.add(person);
            }

            return people;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
