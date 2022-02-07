package ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Statement: Given an array containing N integers and a number S denoting a target sum.
Find all distinct integers that can add up to form target sum.
The numbers in each triplet should be ordered in ascending order and triplets should be ordered too.
Return an empty array if no such triplet exists.

Input: array={1,2,3,4,5,6,7,8,9,15}
S = 18
Output = [1,2,15]
[3,7,8]
[4,6,8]
[5,6,7]
Pattern: Two pointer algorithm
 */
public class Triplets {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,15};
        //List<List<Integer>> triplets = bfsSolution(arr, 18);
        List<List<Integer>> triplets = findTriplets(arr, 18);
        if(triplets.isEmpty())
            System.out.println("thr is no such triplets exists");
        else {
            for (List<Integer> triplet: triplets) {
                System.out.println("[" + triplet.get(0) + ","
                        + triplet.get(1) + ","
                        + triplet.get(2) + "]");
            }
        }
    }

    /*
    Time Complexity: O(N^3)
     */
    public static List<List<Integer>> bfsSolution(int[] arr, int targetSum) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                for(int k = j +1; k < arr.length; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum == targetSum) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(arr[i]);
                        triplet.add(arr[j]);
                        triplet.add(arr[k]);
                        triplets.add(triplet);
                    }
                }
            }
        }

        return triplets;
    }

    /*
    Time Complexity: O(N*logN)
     */
    public static List<List<Integer>> findTriplets(int[] arr, int targetSum) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);

        for(int i = 0; i < arr.length - 2; i++) {
            int j = i+1;
            int k = arr.length - 1;
            while (j < k) {
                int currSum = arr[i];
                currSum += arr[j];
                currSum += arr[k];

                if(currSum == targetSum) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(arr[i]);
                    triplet.add(arr[j]);
                    triplet.add(arr[k]);
                    triplets.add(triplet);
                    j++;
                    k--;
                } else if(currSum < targetSum) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return triplets;
    }
}
