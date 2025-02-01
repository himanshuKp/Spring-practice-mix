package MethodReference;

import java.util.ArrayList;
import java.util.List;

public class GFG4 {
    public static void main(String[] args){
        List<String> personList = new ArrayList<String>();
        personList.add("John");
        personList.add("Jane");
        personList.add("Bob");

        personList.sort(String::compareToIgnoreCase);

        System.out.println(personList);
    }
}
