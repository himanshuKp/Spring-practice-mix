package functionalInterface.instanceMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GFG2 {
    public static void main(String[] args) {
        List<String> personList = new ArrayList<>();

        personList.add("Vijay");
        personList.add("Shankar");
        personList.add("Poonam");

//        Collections.sort(personList, String::compareToIgnoreCase);
        personList.sort(String::compareToIgnoreCase);

        personList.forEach(System.out::println);
    }
}
