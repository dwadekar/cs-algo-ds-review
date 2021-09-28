package ds.strings.P15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public class SortingArrayByLengthMain {
    private static final String [] arr = {"Pune, India", "I", "from", "am"};
    private static final String [] arr2 = {"Pune, India", "I", "from", "am"};

    public static void main(String[] args) {
        System.out.println("############ Method 1 #################");
        long startTimeV1 = System.nanoTime();
        sortArrayByLength1(arr);
        displayExecutionTime(System.nanoTime()-startTimeV1);
        printArray(arr);
        System.out.println("############ Method 2 #################");
        long startTimeV2 = System.nanoTime();
        sortArrayByLength2(arr2);
        displayExecutionTime(System.nanoTime()-startTimeV2);
        printArray(arr2);
    }

    public static void printArray(String[] arr) {
        for (String str : arr) {
            System.out.print(str + " ");
        }
        System.out.println("\n");
    }

    public static void sortArrayByLength1(String[] strings) {
        if(strings == null || strings.length == 0)
            return;
        for (int i = 1; i < strings.length; i++) {
            int j = i;
            while (j > 0 && strings[j -1].length() > strings[j].length()) {
                String temp = strings[j];
                strings[j] = strings[j-1];
                strings[j-1] = temp;
                j--;
            }
        }
    }

    public static void sortArrayByLength2(String[] strings) {
        if(strings == null || strings.length == 0)
            return;
        Arrays.sort(strings, Comparator.comparingInt(String::length));
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " (" +
                TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
