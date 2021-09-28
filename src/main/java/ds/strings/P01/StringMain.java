package ds.strings.P01;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class StringMain {
    private static final String TEXT = "Be strong, be fearless, be beautiful. "
            + "And believe that anything is possible when you have the right "
            + "people there to support you. ";

    private static final String TEXT_CP = TEXT + "😍 I love 💕 you Ӝ so much 💕 😍 🎼🎼🎼!";

    public static void main(String[] args) {
        System.out.println("############ Method 1 #################");
        long startTimeV1 = System.nanoTime();
        Map<Character, Integer> characterIntegerMap1 = Strings.duplicateCountMethod1(TEXT);
        displayExecutionTime(System.nanoTime()-startTimeV1);
        System.out.println(Arrays.toString(characterIntegerMap1.entrySet().toArray()));
        System.out.println("############ Method 2 ################");
        long startTimeV2 = System.nanoTime();
        Map<Character, Integer> characterIntegerMap2 = Strings.duplicateCountMethod2(TEXT);
        displayExecutionTime(System.nanoTime()-startTimeV2);
        System.out.println(Arrays.toString(characterIntegerMap2.entrySet().toArray()));
        System.out.println("############ Method 3 ################");
        long startTimeV3 = System.nanoTime();
        Map<Character, Long> characterIntegerMap3 = Strings.duplicateCountMethod3(TEXT);
        displayExecutionTime(System.nanoTime()-startTimeV3);
        System.out.println(Arrays.toString(characterIntegerMap3.entrySet().toArray()));
        System.out.println("############ Method 4 ################");
        long startTimeV4 = System.nanoTime();
        Map<Character, Long> characterIntegerMap4 = Strings.duplicateCountMethod4(TEXT_CP);
        displayExecutionTime(System.nanoTime()-startTimeV4);
        System.out.println(Arrays.toString(characterIntegerMap4.entrySet().toArray()));
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " (" +
                TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
