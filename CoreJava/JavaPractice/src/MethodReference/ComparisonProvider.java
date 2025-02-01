package MethodReference;

public class ComparisonProvider {
    public static int compareByName(Person person1, Person person2) {
        return person1.getName().compareTo(person2.getName());
    }
    public static int compareByAge(Person person1, Person person2) {
        return person1.getAge().compareTo(person2.getAge());
    }
}
