package streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;


public class _Stream {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Tom", MALE, 10),
                new Person("Jerry", FEMALE, 11),
                new Person("Hal", MALE, 12),
                new Person("Bang", MALE, 10)
        );

        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        //break down the code.
        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = System.out::println;
        people.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(println);

        //----------------------
        people.stream()
                .allMatch(person -> MALE.equals(person.gender)); // check if all people are male.

        //breakdown
        Predicate<Person> personPredicate = person -> MALE.equals(person.gender);
        people.stream()
                .allMatch(personPredicate);

        //calculate sum of ages of all male.
        int sumOfWeights = people.stream()
                .filter(person -> MALE.equals(person.gender))
                .mapToInt(person -> person.age)
                .sum();
        System.out.println(sumOfWeights);
    }

    static class Person {
        private final String name;
        private final Gender gender;
        private final Integer age;

        Person(String name, Gender gender, Integer age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
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
