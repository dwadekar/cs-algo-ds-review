package ds.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class AnagramProblem {

    public static void main(String[] args) {
        String strA = "Mother inLaw";
        String strB = "Hitler Woman";
        System.out.println(isAnagramBySort(strA.toLowerCase().toCharArray(), strB.toLowerCase().toCharArray()));
        System.out.println(isAnagramByCount(strA.toLowerCase().toCharArray(), strB.toLowerCase().toCharArray()));
        System.out.println(inAngramByHashMapCount(strA.toLowerCase().toCharArray(), strB.toLowerCase().toCharArray()));
        System.out.println(IntStream.range(1,5).reduce(2, (a, b) -> a+b));
    }

    public static boolean isAnagramBySort(char[] strA, char[] strB) {
        if(strA == null || strB == null)
            return (strA == null && strB == null) ? true : false;

        if(strA.length != strB.length)
            return false;

        Arrays.sort(strA);
        Arrays.sort(strB);

        for(int i = 0; i < strA.length; i++) {
            if(strA[i] != strB[i])
                return false;
        }

        return true;
    }

    static final int NO_OF_CHARACTERS = 256;

    public static boolean isAnagramByCount(char[] strA, char[] strB) {
        if(strA == null || strB == null)
            return (strA == null && strB == null) ? true : false;

        if(strA.length != strB.length)
            return false;

        Map<Character, Integer> counterMap = new HashMap<Character, Integer>();
        int[] counter = new int[NO_OF_CHARACTERS];

        for(int i = 0; i < strA.length; i++) {
            //counterMap.put(strA[i], 1);
            counter[strA[i]]++;
            counter[strB[i]]--;
        }

        for(int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) return false;
        }

        return true;
    }

    public static boolean inAngramByHashMapCount(char[] strA, char[] strB) {
        if(strA == null || strB == null)
            return (strA == null && strB == null) ? true : false;

        if(strA.length != strB.length)
            return false;

        Map<Character, Integer> counterMap = new HashMap<Character, Integer>();

        for(int i = 0; i < strA.length; i++) {
            counterMap.put(strA[i], 1);
        }

        for(int i = 0; i < strB.length; i++) {
            if(counterMap.containsKey(strB[i]) && counterMap.get(strB[i]) != 0)
                counterMap.put(strB[i], 0);
            else
                counterMap.put(strB[i], 1);
        }

        return counterMap.containsValue(1) ? false : true;
    }
}
