package general.service.impl;

import general.dao.Database;
import general.enums.Gender;
import general.model.Person;
import general.service.GenericService;

import java.util.*;

public class PersonServiceImpl implements GenericService {

    Database database = new Database();


    @Override
    public String add(List t) {
        database.setPeople(t);
        return t.toString();
    }

    @Override
    public Person getById(Long id) {

        for (Person d : database.getPeople()
        ) {
            if (d.getId() == id) {
                return d;
            }

        }
        return null;
    }

    @Override
    public String removeByName(String name) {
        for (Person d : database.getPeople()
        ) {
            if (d.getName().equalsIgnoreCase(name)) {
                database.getPeople().remove(d);
                return "Succesfully removed " + d.toString();
            }

        }
        return null;
    }

    @Override
    public List<Person> getAll() {
        return database.getPeople();
    }

    @Override
    public List<Person> sortByName() {
        System.out.println("1-ascending 2-descending  :");
        int a = new Scanner(System.in).nextInt();
        if (a == 1) {
            List<Person> comparators = database.getPeople().stream().sorted(Comparator.comparing(Person::getName)).toList();
            return comparators;
        } else if (a == 2) {
            List<Person> comparators1 = database.getPeople().stream().sorted(Comparator.comparing(Person::getName).reversed()).toList();
            return comparators1;
        }
        return null;
    }

    @Override
    public List<Person> filterByGender() {
        System.out.println("1-male and 2-female :");
        int number = new Scanner(System.in).nextInt();
        if (number == 1) {
            return database.getPeople().stream().filter(x -> x.getGender().equals(Gender.MALE)).toList();
        } else if (number == 2) {
            return database.getPeople().stream().filter(x -> x.getGender().equals(Gender.FEMALE)).toList();
        }
        return null;
    }

    @Override
    public List<Person> clear() {
        database.getPeople().clear();
        return database.getPeople();
    }
}
