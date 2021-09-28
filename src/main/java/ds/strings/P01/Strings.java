package ds.strings.P01;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Strings {
    public Strings() {
        throw new IllegalArgumentException("Can't be instantiated directly");
    }

    public static Map<Character, Integer> duplicateCountMethod1(String input) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        if(input == null || input.isEmpty()) {
            return Collections.emptyMap();
        }

        for(int i = 0; i < input.length(); i++) {
            Character ch = input.charAt(i);
            if(characterIntegerMap.containsKey(ch)) {
                int c = characterIntegerMap.get(ch);
                characterIntegerMap.put(ch, ++c);
            } else {
                characterIntegerMap.put(ch, 1);
            }
        }

        return characterIntegerMap;
    }

    public static Map<Character, Integer> duplicateCountMethod2(String str) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        if(str == null || str.isEmpty()) {
            return Collections.emptyMap();
        }

        for(int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            characterIntegerMap.compute(ch, (character, integer) -> (integer == null) ? 1 : ++integer);
        }

        return characterIntegerMap;
    }

    public static Map<Character, Long> duplicateCountMethod3(String str) {
        if(str == null || str.isEmpty()) {
            return Collections.emptyMap();
        }
        return str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }

    public static Map<Character, Long> duplicateCountMethod4(String str) {
        if(str == null || str.isEmpty()) {
            return Collections.emptyMap();
        }
        return str.codePoints().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }
}
