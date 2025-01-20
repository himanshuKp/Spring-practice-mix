package functionalInterface.instanceMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}

class ComparisonProvider {
    public int compareByName(Person a, Person b) {
        return a.getName().compareTo(b.getName());
    }

    public int compareByAge(Person a, Person b) {
        return a.getAge().compareTo(b.getAge());
    }
}

public class GFG1 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Satish", 30));
        personList.add(new Person("Vijay", 20));
        personList.add(new Person("Ajay", 25));

        ComparisonProvider comparator = new ComparisonProvider();

        personList.sort(comparator::compareByName);

        System.out.println("Sort by name: ");

        personList.stream()
                .map(Person::getName)
                .forEach(System.out::println);

        System.out.println();

        personList.sort(comparator::compareByAge);

        System.out.println("Sort by age: ");

        personList.stream()
                .map(Person::getAge)
                .forEach(System.out::println);
    }
}
