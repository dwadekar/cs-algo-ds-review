package ds.strings.P05;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class VowelsNConsonantMain {
    private static final Set<Character> vowelsSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    private static final String TEXT= "WEUIWOQWINSdoWE#@#121";

    public static void main(String[] args) {
        Pair<Integer, Integer> countPair = countVowelsNConsonants1(TEXT);
        System.out.println("Vowels count: " + countPair.getLeft() + " ,Consonant count: " + countPair.getRight());
        Pair<Long, Long> countPair2 = countVowelsNConsonants2(TEXT);
        System.out.println("Vowels count: " + countPair2.getLeft() + " ,Consonant count: " + countPair2.getRight());
    }

    public static Pair<Integer, Integer> countVowelsNConsonants1(String str) {
        if(str == null || str.isEmpty()) {
            return Pair.of(0, 0);
        }
        str = str.toLowerCase();
        int countVowels = 0, countConsonants = 0;
        for(int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if(vowelsSet.contains(ch)) {
                countVowels++;
            } else if(ch >= 'a' && ch <= 'z') {
                countConsonants++;
            }
        }
        return Pair.of(countVowels, countConsonants);
    }

    public static Pair<Long, Long> countVowelsNConsonants2(String str) {
        if(str == null || str.isEmpty()) {
            return Pair.of(0L, 0L);
        }
        str = str.toLowerCase();

        long vowelsCount = str.chars().filter(c -> vowelsSet.contains((char)c)).count();
        long consonantCount = str.chars().filter(c -> !vowelsSet.contains((char)c)).filter(ch -> (ch >= 'a' && ch <= 'z')).count();

        return Pair.of(vowelsCount, consonantCount);
    }
}
