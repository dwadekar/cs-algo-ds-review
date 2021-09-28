package ds.arrays.easy;

import java.util.Arrays;
import java.util.Scanner;

/*
Time Complexity: waveArrayForm_Sorted - O(N)
waveArrayForm - O(N)

Space complexity - O(1) for both methods
 */
public class WaveArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the given array for WaveArray process: ");
        String[] numbers = sc.nextLine().split(" ");
        //sc.nextLine();

        int[] arr = Arrays.stream(numbers).mapToInt(x -> Integer.parseInt(x)).toArray();
        //waveArrayForm_Sorted(arr);
        waveArrayForm(arr);
        for (int num: arr) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
    }

    public static void waveArrayForm_Sorted(int[] arr) {
        int temp = 0;
        for(int i = 0; i < arr.length - 1; i+=2) {
            temp = arr[i+1];
            arr[i+1] = arr[i];
            arr[i] = temp;
        }
    }

    public static void waveArrayForm(int[] arr) {
        int temp = 0;
        for(int i = 0; i < arr.length; i+=2) {
            if(i > 0 && arr[i-1] > arr[i]) {
                temp = arr[i-1];
                arr[i-1] = arr[i];
                arr[i] = temp;
            }

            if(i < arr.length - 1 && arr[i] < arr[i+1]) {
                temp = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
