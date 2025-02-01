package MethodReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GFG2 {
//    static method to compare with names
    public static int compareByName(Person person1, Person person2) {
        return person1.getName().compareTo(person2.getName());
    }

//    static method to compare with age
    public static int compareByAge(Person person1, Person person2) {
        return person1.getAge().compareTo(person2.getAge());
    }

    public static void main(String[] args){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("John Doe", 18));
        personList.add(new Person("Vicky Doe", 19));
        personList.add(new Person("Sachin Doe", 20));

        personList.sort(GFG2::compareByName);

        System.out.println("Sorted by name: ");

        personList.stream()
                .map(Person::getName)
                .forEach(System.out::println);

        System.out.println();

        personList.sort(GFG2::compareByAge);

        System.out.println("Sorted by age: ");

        personList.stream()
                .map(Person::getAge)
                .forEach(System.out::println);
        System.out.println();
  }
}
