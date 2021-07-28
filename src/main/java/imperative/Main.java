package imperative;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static imperative.Main.Gender.*;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("Tom", MALE),
                new Person("Jerry", FEMALE),
                new Person("Hal", MALE),
                new Person("Bang", MALE)
        );

        //Imperative approach
        System.out.println("---Imperative approach--");
        List<Person> females = new ArrayList<>();
        for (Person person: personList) {
            if (FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        for (Person person: females) {
            System.out.println(person);
        }

        //Declarative approach
        System.out.println("---Declarative approach--");
        personList.stream()
                .filter(person -> FEMALE.equals(person.gender))
//                .collect(Collectors.toList())
                .forEach(System.out::println);
        //break down:
        List<Person> females2 = personList.stream().filter(person -> FEMALE.equals(person.gender)).collect(Collectors.toList());
        females2.forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
