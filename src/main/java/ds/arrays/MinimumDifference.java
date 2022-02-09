package ds.arrays;

import javafx.util.Pair;

import java.util.Arrays;

/*
Problem Statement: Implement a function that takes in two non-empty arrays of integers, finds the pair of numbers
(one from each array) whose absolute difference is closest to zero and returns pair containing these two numbers
with first number from array. Only one such pair exist for the test.

Input: array1={23,5,10,17,30}
       array2={26, 134, 135, 14, 19 }
Output = [17,19]
Pattern:

BFS Solution: Use two loops and find out minimum absolute difference with each pair combination.
But time complexity is O(N*N)
 */
public class MinimumDifference {
    public static void main(String[] args) {
        int[] array1={23,5,10,17,30};
        int[] array2={26, 134, 135, 14, 19 };
        Pair<Integer, Integer> pair = findMinPair(array1, array2);
        System.out.println("[" + pair.getKey() + "," + pair.getValue() + "]");
    }

    public static Pair<Integer, Integer> findMinPair(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);

        int minimumDiff = Integer.MAX_VALUE;
        int i = 0, j = 0;
        Pair<Integer, Integer> pair = new Pair<>(-1, -1);

        int m = array1.length;
        int n = array2.length;

        while(i < m && j < n) {
            if(Math.abs(array1[i] - array2[j]) < minimumDiff) {
                minimumDiff = Math.abs(array1[i] - array2[j]);
                pair = new Pair<>(array1[i], array2[j]);
            }
            if(array1[i] < array2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return pair;
    }
}
