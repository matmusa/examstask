package general.service.impl;

import general.dao.Database;
import general.enums.Gender;
import general.model.Animal;
import general.service.GenericService;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AnimalServiceIImpl implements GenericService {
    Database database = new Database();


    @Override
    public String add(List t) {
        database.setAnimals(t);
        return t.toString();
    }

    @Override
    public Animal getById(Long id) {
        for (Animal d : database.getAnimals()
        ) {
            if (d.getId() == id) {
                return d;
            }

        }
        return null;
    }

    @Override
    public String removeByName(String name) {
        for (Animal d : database.getAnimals()
        ) {
            if (d.getName().equalsIgnoreCase(name)) {
                database.getAnimals().remove(d);
                return "Succesfully removed " + d.toString();
            }

        }
        return null;
    }

    @Override
    public List<Animal> getAll() {
        return database.getAnimals();
    }

    @Override
    public List<Animal> sortByName() {
        System.out.println("1-ascending 2-descending");
        int a = new Scanner(System.in).nextInt();
        if (a == 1) {
            List<Animal> animals = database.getAnimals().stream().sorted(Comparator.comparing(Animal::getName)).toList();
            return animals;
        } else if (a == 2) {
            List<Animal> animals = database.getAnimals().stream().sorted(Comparator.comparing(Animal::getName).reversed()).toList();
            return animals;
        }
        return null;

    }

    @Override
    public List<Animal> filterByGender() {
        System.out.println("1-ale and 2-female :");
        int number = new Scanner(System.in).nextInt();
        if (number == 1) {
            return database.getAnimals().stream().filter(x -> x.getGender().equals(Gender.MALE)).toList();
        } else if (number == 2) {
            return database.getAnimals().stream().filter(x -> x.getGender().equals(Gender.FEMALE)).toList();
        }
        return null;
    }

    @Override
    public List<Animal> clear() {
        database.getAnimals().clear();
        return database.getAnimals();
    }
}



