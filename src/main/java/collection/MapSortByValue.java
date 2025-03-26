import java.util.*;
import java.util.stream.Collectors;

public class MapSortByValue {
    public static void main(String[] args) {
        Map<Integer, Name> map = new HashMap<>();
        map.put(1, new Name("a", 20));
        map.put(2, new Name("b", 10));
        map.put(3, new Name("c", 30));

        // Print the original map
        map.forEach((key, value) -> System.out.println(value.name + " - " + value.age));

        // Sort the map by value (age in descending order)
        Map<Integer, Name> sortedMap = map.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().age - e1.getValue().age)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        // Print the sorted map
        sortedMap.forEach((key, value) -> System.out.println(value.name + " - " + value.age));
    }

    static class Name {
        String name;
        Integer age;

        Name(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }
}
