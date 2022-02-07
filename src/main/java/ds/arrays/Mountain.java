package ds.arrays;

/*
Problem Statement: Write a function that takes input array of distinct integers and return the length of highest mountain.
Atleast 3 numbers are required to form a mountain.

Input: array={5,6,1,2,3,4,5,4,3,2,0,1,2,3,-2,4}
Output = 9
Pattern: Two pointer algorithm
 */
public class Mountain {
    public static void main(String[] args) {
        int[] array={5,6,1,2,3,4,5,4,3,2,0,1,2,3,-2,4};
        System.out.println("Largest mountain length: " + findMaxMountain(array));
    }

    public static int findMaxMountain(int[] arr) {
        if(arr == null || arr.length < 3) {
            return 0;
        }
        int largest = 0;

        for(int i = 1; i <= arr.length - 2;) {
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
                int cnt = 1;
                int j = i;
                while (j >= 1 && arr[j] > arr[j-1]) {
                    j--;
                    cnt++;
                }
                while(i <= arr.length - 2 && arr[i] > arr[i+1]) {
                    i++;
                    cnt++;
                }
                largest = Math.max(largest, cnt);
            } else {
                i++;
            }
        }
        return largest;
    }
}
