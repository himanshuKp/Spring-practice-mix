package MethodReference;

import java.util.ArrayList;
import java.util.List;

public class GFG3 {
    public static void main(String[] args){
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("John Doe", 18));
        personList.add(new Person("Vicky Doe", 29));
        personList.add(new Person("Susan Doe", 20));

        personList.sort(ComparisonProvider::compareByName);

        System.out.println("Sorted by name:");
        personList.stream()
                .map(Person::getName)
                .forEach(System.out::println);

        System.out.println();

        personList.sort(ComparisonProvider::compareByAge);
        System.out.println("Sorted by age:");

        personList.stream()
                .map(Person::getAge)
                .forEach(System.out::println);

        System.out.println();
    }
}
