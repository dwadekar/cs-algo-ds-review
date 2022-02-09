package ds.arrays;

import javafx.util.Pair;

import java.util.Arrays;

/*
Problem Statement: Given an array of size atleast two, find the smallest that needs to be sorted in place so that entire
input array becomes sorted.
If input array already sorted, the function should return [-1,-1],otherwise start & end of index of smallest subarray.

Input: array={1,2,3,4,5,8,6,7,9,10,11}
Output = [5,7]
Pattern: Determining the maximum with each iteration from left and right of an array
 */
public class SubArray {
    public static void main(String[] args) {
        int[] array={1,2,3,4,5,8,6,7,9,10,11};
        //Pair<Integer, Integer> pair = bfsSolution(array);
        Pair<Integer, Integer> pair = findSubArray(array);
        System.out.println("SubArray to sort: [" + pair.getKey() + ", " + pair.getValue() + "]");
    }

    /*
    Time Complexity : O(N*logN)
     */
    public static Pair<Integer, Integer> bfsSolution(int[] array) {
        int[] originalArr = array.clone();
        Arrays.sort(array);

        int i = 0;
        int n = array.length;

        while(i < n && array[i]==originalArr[i]) {
            i++;
        }
        int j = n -1;
        while (j>=0 && array[j] == originalArr[j]) {
            j--;
        }
        if(i == n -1) {
            return new Pair<>(-1, -1);
        }

        return new Pair<>(i, j);
    }

    public static Pair<Integer, Integer> findSubArray(int[] array) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++) {
            int element = array[i];
            if(outOfOrder(array, i)) {
                smallest = Math.min(smallest, element);
                largest = Math.max(largest, element);
            }
        }

        if(smallest == Integer.MAX_VALUE)
            return new Pair<>(-1, -1);
        int i = 0;

        while(smallest >= array[i]) {
            i++;
        }

        int j = array.length - 1;
        while(largest <= array[j]) {
            j--;
        }

        return new Pair<>(i,j);
    }

    private static boolean outOfOrder(int[] array, int i) {
        int x = array[i];
        if(i == 0) {
            return x > array[1];
        }
        if(i == array.length - 1) {
            return x < array[i - 1];
        }

        return x > array[i + 1] || x < array[i-1];
    }
}
