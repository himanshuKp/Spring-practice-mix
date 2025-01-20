package functionalInterface.instanceMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

class Person1 {
    private String name;
    private Integer age;

    public Person1() {
        Random random = new Random();
        this.name = random.ints(97, 122+1)
                .limit(7)
                .collect(
                        StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append
                ).toString();
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}

public class GFG3 {
    public static <T> List<T> getObjectList(int length, Supplier<T> objectSupply) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(objectSupply.get());
        }
        return list;
    }

    public static void main(String[] args) {
        List<Person1> person1List =
                getObjectList(5, Person1::new);

        person1List.stream()
                .map(Person1::getName)
                .forEach(System.out::println);
    }
}
