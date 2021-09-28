package ds.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostFrequent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] numbers = sc.nextLine().split(" ");

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < numbers.length; i++) {
            if(map.containsKey(Integer.parseInt(numbers[i])))
                map.put(Integer.parseInt(numbers[i]), map.get(Integer.parseInt(numbers[i])) + 1);
            else
                map.put(Integer.parseInt(numbers[i]), 1);
        }

        int max = map.entrySet().stream().max((entry1, entry2) -> Integer.compare(entry1.getValue(), entry2.getValue())).get().getKey();

        System.out.println(max);
    }
}
