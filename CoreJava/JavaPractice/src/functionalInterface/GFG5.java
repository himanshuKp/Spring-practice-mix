package functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GFG5 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(6);
        list.add(9);
        list.add(4);
        list.add(20);

        System.out.println("Printing the collection: "+list);

        System.out.println();

        List<Integer> result = list.stream()
                .filter(element -> element % 2 == 0)
                .toList();

        System.out.println("Printing the list after stream operation: "+result);
    }
}
