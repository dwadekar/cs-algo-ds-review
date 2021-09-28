package ds.strings.P18;

public class AnagramStringsMain {
    private static final String TEXT_1 = "heLLo World";
    private static final String TEXT_2 = "olrdo hellWy";

    public static void main(String[] args) {
        System.out.println(isAnagramStrings(TEXT_1, TEXT_2));
    }

    public static boolean isAnagramStrings(String str1, String str2) {
        if((str1 == null || str2 == null) || (str1.isEmpty() || str2.isEmpty()) || (str1.length() != str2.length())) {
            return false;
        }
        int[] chCount = new int[256];
        char[] ch1 = str1.replaceAll(" ", "").toLowerCase().toCharArray();
        char[] ch2 = str2.replaceAll(" ", "").toLowerCase().toCharArray();

        for (int i = 0; i < ch1.length; i++) {
            chCount[ch1[i]]++;
            chCount[ch2[i]]--;
        }
        for (int count : chCount) {
            if(count != 0)
                return false;
        }
        return true;
    }
}
