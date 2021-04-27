package cho.example.api.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static List<String> returnList(){
        return Arrays.asList("c","a","b").stream().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        returnList().forEach(System.out::println);
    }
}
