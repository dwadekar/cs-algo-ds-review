package ds.strings.P04;

public class NumericStringMain {
    private static final String TEXT_NUMERIC = "34434";
    private static final String TEXT_STRING = "erwer3434";

    public static void main(String[] args) {
        System.out.println("Is given string isNumeric: " + isNumericString1(TEXT_NUMERIC));
        System.out.println("Is given string isNumeric: " + isNumericString1(""));
        System.out.println("Is given string isNumeric: " + isNumericString1(null));
        System.out.println("Is given string isNumeric: " + isNumericString1(TEXT_STRING));
        System.out.println("Is given string isNumeric: " + isNumericString2(TEXT_STRING));
        System.out.println("Is given string isNumeric: " + isNumericString2(null));
        System.out.println("Is given string isNumeric: " + isNumericString2(TEXT_NUMERIC));
    }

    public static boolean isNumericString1(String str) {
        if(str == null || str.isEmpty()) {
            return false;
        }
        for(int i = 0; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumericString2(String str) {
        if(str == null || str.isEmpty()) {
            return false;
        }
        return !str.chars().anyMatch(n -> !Character.isDigit(n));
    }
}
