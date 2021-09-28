package ds.arrays.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateZeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the given array for DplicateZero process: ");
        String[] numbers = sc.nextLine().split(" ");
        sc.nextLine();

        int[] arr = Arrays.stream(numbers).mapToInt(x -> Integer.parseInt(x)).toArray();
        duplicateZeros(arr);
        for (int num: arr) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
    }

    public static void duplicateZeros(int[] arr) {
        int count = 0;
        int length = arr.length - 1;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i <= length - count; i++) {
            if(arr[i] == 0) {
                if(i == length - count) {
                    arr[i] = 0;
                    length-=1;
                    break;
                }
                count++;
            }
        }

        int last = length - count;

        for(int j = last; j >=0; j--) {
            if(arr[j] == 0) {
                arr[j + count] = 0;
                count --;
                arr[j + count] = 0;
            } else {
                arr[j + count] = arr[j];
            }
        }
    }
}
