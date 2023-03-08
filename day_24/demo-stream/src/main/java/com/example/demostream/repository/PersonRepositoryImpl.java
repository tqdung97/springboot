package com.example.demostream.repository;

import com.example.demostream.db.PersonDB;
import com.example.demostream.model.Person;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PersonRepositoryImpl implements PersonRepository{
    @Override
    public List<Person> getAll() {
        return PersonDB.people;
    }

    @Override
    public List<Person> sortPeopleByFullName() {
        return PersonDB.people
                .stream()
                .sorted(Comparator.comparing(Person::getFullName)).collect(Collectors.toList());
    }

    @Override
    public List<Person> sortPeopleByFullNameReversed() {
        return PersonDB.people
                .stream()
                .sorted(Comparator.comparing(Person::getFullName).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getSortedJobs() {
        return PersonDB.people.stream().map(Person::getJob).sorted().toList();
    }

    @Override
    public List<String> getSortedCities() {
        return PersonDB.people.stream().map(Person::getCity).sorted().toList();
    }

    @Override
    public Map<String, List<Person>> groupPeopleByCity() {
        Map<String, List<Person>> cities_population = PersonDB.people
                .stream()
                .collect(Collectors.groupingBy(Person::getCity));

        System.out.println(cities_population);

        return cities_population.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, HashMap::new));
    }

    @Override
    public Map<String, Integer> groupJobByCount() {
        return null;
    }

    @Override
    public HashMap<String, Integer> findTop5Jobs() {
        return null;
    }

    @Override
    public List<Map.Entry<String, Long>> findTop5PopulationCitis() {
        return null;
    }

    @Override
    public List<Map.Entry<String, Map.Entry<String, Long>>> findTopJobInCity() {
        return null;
    }

    @Override
    public Map<String, Double> averageJobSalary() {
        return null;
    }

    @Override
    public List<Map.Entry<String, Double>> top5HighestSalaryCities() {
        return null;
    }

    @Override
    public Map<String, Double> averageJobAge() {
        return null;
    }

    @Override
    public HashMap<String, Float> ratioMaleFemalePerCity() {
        return null;
    }

    @Override
    public Map<String, Double> averageCityAge() {
        return null;
    }

    @Override
    public List<String> find5CitiesHaveMostSpecificJob(String job) {
        return null;
    }
}
