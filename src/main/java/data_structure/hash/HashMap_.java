package data_structure.hash;

import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HashMap_ {
    static HashMap<String, String> map = new HashMap<>();
    public static void main(String args []){
        map.put("A", "AA");
        map.put("B", "BB");
        map.put("C", "CC");

        // keyset
        map.keySet().forEach(System.out::printf);
        System.out.println();

        // values
        map.values().forEach(System.out::printf);
        Stream.of(map.values())
                        .collect(Collectors.toList());
        System.out.println();

        // entryset
        map.entrySet().forEach(System.out::println);
    }
}


