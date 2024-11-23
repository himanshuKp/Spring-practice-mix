package streams;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream1 {
    public static void main(String[] args) {
//        Stream<Integer> intStream = Stream.generate(new Random()::nextInt).limit(100);
//        System.out.println(intStream.collect(Collectors.toList()));

//        Stream<Integer> integerStream = Stream.generate(()->new Random().nextInt(10))
//                .limit(20);
//        System.out.println(integerStream.collect(Collectors.toList()));

//        IntStream.rangeClosed(1,10).forEachOrdered(System.out::println);

//        List<Integer> integerList = List.of(1,2,3,4,5,6,7,8,9,10);
//        integerList.parallelStream().forEach(System.out::println);  // will not keep the order maintained
//        integerList.parallelStream().forEachOrdered(System.out::println); // will keep the order maintained
    }
}
