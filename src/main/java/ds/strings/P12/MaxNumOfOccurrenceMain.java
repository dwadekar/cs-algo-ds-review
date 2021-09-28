package ds.strings.P12;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxNumOfOccurrenceMain {
    private static final String TEXT = "Sjsdiweopodfl lwelk kwe";

    public static void main(String[] args) {
        Pair<Character, Integer> maxPair = maxNumOfOccurredChar1(TEXT);
        System.out.println("Character: " + maxPair.getLeft() + " having occurrences: " + maxPair.getRight());
        Pair<Character, Long> maxPair2 = maxNumOfOccurredChar2(TEXT);
        System.out.println("Character: " + maxPair2.getLeft() + " having occurrences: " + maxPair2.getRight());
    }

    public static Pair<Character, Integer> maxNumOfOccurredChar1(String str) {
        if(str == null || str.isEmpty()) {
            return Pair.of(Character.MIN_VALUE, Integer.MIN_VALUE);
        }
        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(!Character.isWhitespace(ch)) {
                characterIntegerMap.compute(ch, (character, integer) -> (integer == null) ? 1 : ++integer);
            }
        }
        int max_occurrence = Collections.max(characterIntegerMap.values());

        for (Map.Entry<Character, Integer> mapEntry: characterIntegerMap.entrySet()) {
            if(mapEntry.getValue() == max_occurrence) {
                return Pair.of(mapEntry.getKey(), max_occurrence);
            }
        }

        return Pair.of(Character.MIN_VALUE, Integer.MIN_VALUE);
    }

    public static Pair<Character, Long> maxNumOfOccurredChar2(String str) {
        if(str == null || str.isEmpty()) {
            return Pair.of(Character.MIN_VALUE, -1L);
        }
        return str.chars().filter(c -> !Character.isWhitespace(c)).mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(p -> Pair.of(p.getKey(), p.getValue())).orElse(Pair.of(Character.MIN_VALUE, -1L));
    }

}
