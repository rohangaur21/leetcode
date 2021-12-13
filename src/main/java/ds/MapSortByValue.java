package ds;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSortByValue {
    public static void main(String[] args) {
        Map<Integer, Name> map = new HashMap<>();
        map.put(1, new Name("a", 20));
        map.put(2, new Name("b", 10));
        map.put(3, new Name("c", 30));

        for (Integer i : map.keySet()) {
            System.out.println(map.get(i).name + " - " + map.get(i).age);
        }
        Map<Integer, Name> sortMap = map.entrySet().stream().sorted((e1, e2) -> e2.getValue().age - e1.getValue().age)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (Integer i : sortMap.keySet()) {
            System.out.println(map.get(i).name + " - " + map.get(i).age);
        }
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
