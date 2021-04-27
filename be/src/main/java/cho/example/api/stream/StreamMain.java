package cho.example.api.stream;

import java.util.List;

public class StreamMain {
    public static void main(String... args) {
        new StreamUtil().arrayToList(new String[]{"a","b","c"}).forEach(System.out::println);
    }
}
