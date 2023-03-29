import general.enums.Gender;
import general.model.Animal;
import general.model.Person;
import general.service.impl.AnimalServiceIImpl;
import general.service.impl.PersonServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        Person person = new Person(1, "Matmusa", 21, Gender.MALE);
        Person person2 = new Person(2, "Murat", 26, Gender.MALE);
        Person person3 = new Person(3, "Manas", 28, Gender.MALE);
        Person person4 = new Person(4, "Manura", 23, Gender.FEMALE);
        Person person5 = new Person(5, "Mahabat", 20, Gender.FEMALE);
        Animal animal = new Animal(1, "cow", 7, Gender.FEMALE);
        Animal animal2 = new Animal(2, "dog", 7, Gender.MALE);
        Animal animal3 = new Animal(3, "cat", 7, Gender.FEMALE);

        List<Animal> animals = new ArrayList<>();
        animals.add(animal);
        animals.add(animal2);
        animals.add(animal3);


        PersonServiceImpl personService = new PersonServiceImpl();
        AnimalServiceIImpl animalService = new AnimalServiceIImpl();
        System.out.println("1 People\n" +
                "2 Animals\n");
        int a = new Scanner(System.in).nextInt();
        if (a == 1) {
            while (true) {
                List<Person> people = new ArrayList<>();
                people.add(person);
                people.add(person2);
                people.add(person3);
                people.add(person4);
                people.add(person5);
                System.out.println("1. add new person\n" +
                        "        2.  get person by id \n" +
                        "        3. remove person by name\n " +
                        "        4.get all()\n" +
                        "        5. sort by name 1 ди басканда asc, 2 ни басканда des \n" +
                        "        6. filter by gender 1 ди басканда female, 2 ни басканда male \n" +
                        "        7.person clear()\n");
                ;
                int c = new Scanner(System.in).nextInt();
                switch (c) {
                    case 1 -> System.out.println(personService.add(people));
                    case 2 -> System.out.println(personService.getById(2L));
                    case 3 -> System.out.println(personService.removeByName(person3.getName()));
                    case 4 -> System.out.println(personService.getAll());
                    case 5 -> System.out.println(personService.sortByName());
                    case 6 -> System.out.println(personService.filterByGender());
                    case 7 -> System.out.println(personService.clear());
                }
            }
        } else if (a == 2) {
            while (true) {

            System.out.println("1. add new animal\n" +
                    "        2.  get animal by id \n" +
                    "        3. remove animal by name/ " +
                    "        4.get all()\n" +
                    "        5. sort by name 1 ди басканда asc, 2 ни басканда des \n" +
                    "        6. filter by gender 1 ди басканда female, 2 ни басканда male \n" +
                    "        7.animal clear();");
            int c = new Scanner(System.in).nextInt();
            switch (c) {
                case 1 -> System.out.println(animalService.add(animals));
                case 2 -> System.out.println(animalService.getById(2L));
                case 3 -> System.out.println(animalService.removeByName(animal.getName()));
                case 4 -> System.out.println(animalService.getAll());
                case 5 -> System.out.println(animalService.sortByName());
                case 6 -> System.out.println(animalService.filterByGender());
                case 7 -> System.out.println(animalService.clear());

            }


        }








     /*   1) Жаны проект тузунуз.
        2) 3 жаны пакет тузунуз - model, service, dao.
        3) model пакеттин ичине Person,Animal деген класс тузунуз, свойствалары - id, name, age, Gender .
                - Genderди enum кылып башка пакетке тузуп койсонуз болот.
        4) dao пакеттин ичине Database деген класс тузунуз, ичинде 2 свойствасы болот - userлер, animalдар. Бул класс биздин база
        данныхыбыз болот.
        5) service пакеттин ичине GenericService деген generic interface тузунуз жана impl деген пакет тузуп коюнуз.
        6) GenericServiceтин ичинде 7 метод болот:
        - String add(List<T>t);
        - T getById(Long id);
        - String removeByName(String name);
        - List<T> getAll();
        - List<T> sortByName(); 1 ди басканда ascending, 2 ни басканда descending кылып сорттосун
                - List<T> filterByGender(); 1 ди басканда female, 2 ни басканда male кылып фильтрлесин
                - List<T> clear();
        7) impl пакеттин ичине PersonServiceImpl, AnimalServiceImpl деген класстарды тузунуз, бул класстар GenericService интерфейсин ишке ашырат жана бул класстарда свойства катары биздин база данныхыбыз болот(Database).
        8) Класстарда GenericService интерфейсинин бардык методдорун ишке ашырыныз. PersonServiceImpl методдору стандарттык турдо ал   эми AnimalServiceImpl да айрым методдору stream аркылуу ишке ашырылсын.
        9) Main класста бардык методдорду чакырып иштетиниз.
        10. Методдорду озгортууго болбойт, условияда кандай берилсе ошол бойдон иштегиле!*/


    }


}

}