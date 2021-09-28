package ds.arrays;

import java.util.HashSet;
import java.util.Set;

public class DuplicateArrayProblem {

    public static void main(String[] args) {
        int[] arr = {1,4,3,4,5,2,1};
        int[] arr1 = null;
        int[] arr2 = {};

        duplicatesByHashTable(arr1);
        duplicatesByIndex(arr1);

        duplicatesByHashTable(arr2);
        duplicatesByIndex(arr2);

        duplicatesByHashTable(arr);
        duplicatesByIndex(arr);
    }

    /*
    This is generic method applicable to each element present within
    Array. No restriction as such to call this method.

    Time Complexity - O(N)
     */
    public static void duplicatesByHashTable(int[] arr) {
        if(arr == null || arr.length == 0) {
            System.out.println("No elements found in an array..");
            return;
        }
        Set<Integer> counter = new HashSet<Integer>();

        System.out.print("\nDuplicate Elements are: ");
        for(int i = 0; i < arr.length; i++) {
            if(!counter.add(arr[i]))
                System.out.print(arr[i] + " ");
            else
            counter.add(arr[i]);
        }
    }

    /*
    This is method is useful in case of -
    1. Elements present in an array is greater than 0
    2. Elements present in should be in range of 0 to array.length

    Time Complexity - O(N)
     */
    public static void duplicatesByIndex(int[] arr) {
        if(arr == null || arr.length == 0) {
            System.out.println("No elements found in an array..");
            return;
        }

        System.out.print("\nDuplicate Elements are: ");
        for(int i = 0; i < arr.length; i++) {
            if(arr[Math.abs(arr[i])] > 0)
                arr[Math.abs(arr[i])] = - arr[Math.abs(arr[i])];
            else
                System.out.print(Math.abs(arr[i]) + " ");
        }
    }
}
