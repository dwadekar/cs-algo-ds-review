package ds.strings.P02;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatCharMain {

    private static final String TEXT = "eello World";

    public static void main(String[] args) {
        System.out.println("############ Method 1 #################");
        long startTimeV1 = System.nanoTime();
        System.out.println(firstNonRepeatedChar1(TEXT));
        displayExecutionTime(System.nanoTime()-startTimeV1);
        System.out.println("############ Method 2 #################");
        long startTimeV2 = System.nanoTime();
        System.out.println(firstNonRepeatedChar2(TEXT));
        displayExecutionTime(System.nanoTime()-startTimeV2);
    }

    public static Character firstNonRepeatedChar1(String str) {
        Map<Character, Integer> characterIntegerMap = new LinkedHashMap<>();

        if(str == null || str.isEmpty()) {
            return Character.MIN_VALUE;
        }

        /*for(int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            characterIntegerMap.compute(ch, (character, integer) -> (integer == null) ? 1 : ++integer);
        }*/

        for(int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if(characterIntegerMap.containsKey(ch)) {
                int c = characterIntegerMap.get(ch);
                characterIntegerMap.put(ch, ++c);
            } else {
                characterIntegerMap.put(ch, 1);
            }
        }

        for(Map.Entry<Character, Integer> mapEntry : characterIntegerMap.entrySet()) {
            if(mapEntry.getValue() == 1) {
                return mapEntry.getKey();
            }
        }

        return Character.MIN_VALUE;
    }

    public static Character firstNonRepeatedChar2(String str) {
        if(str == null || str.isEmpty()) {
            return Character.MIN_VALUE;
        }
        Map<Character, Long> characterIntegerMap = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        return characterIntegerMap.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().map(Map.Entry::getKey).orElse(Character.MIN_VALUE);
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " (" +
                TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
