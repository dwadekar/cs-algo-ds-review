package ds.arrays;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

/*
Problem Statement: Given an array containing N integers and a number S denoting a target sum.
Find two distinct integers that can pair up to form target sum. Let us assume there will only one such a pair.

Input: array={10, 5, 2, 3, -6, 9, 11}
S = 4
Output = [10, -6]
Pattern: Storing unique numbers for fetching it with time complexity of O(1)
 */
public class Pairs {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 3, -6, 9, 11};
        Pair<Integer, Integer> pair = bfsSolution(arr, 4);
        if(pair == null) {
            System.out.println("No such pair exists");
        } else
            System.out.println("[" + pair.getKey() + ", " + pair.getValue() + "]");

        pair = findPair(arr, 15);
        if(pair == null) {
            System.out.println("No such pair exists");
        } else
            System.out.println("[" + pair.getKey() + ", " + pair.getValue() + "]");

    }

    /*
    Time Complexity: O(N*N)
     */
    private static Pair<Integer, Integer> bfsSolution(int[] arr, int targetSum) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if(sum == targetSum) {
                    return new Pair<>(arr[i], arr[j]);
                }
            }
        }

        return null;
    }

    /*
    There is another approach with time Complexity of O(N*logN). where we have to sort the given array and then search targetSum - arr[j]
    in remaining part of an array whether it exists or not.
    Sorting - O(N*logN) + Searching - O(N*logN)
     */

    /*
    Time Complexity: O(N)
     */
    private static Pair<Integer, Integer> findPair(int[] arr, int targetSum) {
        Set<Integer> integerSet = new HashSet<>();

        for (int j : arr) {
            if (integerSet.contains(targetSum - j)) {
                return new Pair<>(j, (targetSum - j));
            }
            integerSet.add(j);
        }

        return null;
    }
}
