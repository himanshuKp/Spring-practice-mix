package functionalInterface;

import java.util.Arrays;
import java.util.List;

public class GFG6 {
    public static void main(String[] args) {
        String[] inputString = {"Geeks", "Geek", "Coder", "geeks", "GeeksForGeeks", "Guys"};
        List<String> filteredString = Arrays.stream(inputString).filter(obj -> obj.length() == 5).map(String::toUpperCase).toList();
        System.out.println(filteredString);
    }
}
