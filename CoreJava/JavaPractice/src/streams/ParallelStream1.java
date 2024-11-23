package streams;

import java.util.Arrays;
import java.util.List;

public class ParallelStream1 {
    public static void main(String[] args) {
        //create a list
        List<String> list = Arrays.asList("Hello ", "G", "E", "E", "K", "S!");
        //use parallelstream() method for parallel stream
//        list.parallelStream().forEach(System.out::println);
        list.parallelStream().forEachOrdered(System.out::println);
    }
}
