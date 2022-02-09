package ds.arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/*
Problem Statement: Given an array containing N integers, find the length of longest band.
A band is defined as a subsequence which can be re-ordered in such a manner all elements appear consecutive
(i.e. with absolute difference of 1 between neighbouring elements).

Input: array={1,9,3,0,18,5,2,4,10,7,12,6}
Output = 8
Pattern: Storing unique numbers for fetching it with time complexity of O(1)
 */
public class LongestBand {
    public static void main(String[] args) {
        int[] array={1,9,3,0,18,5,2,4,10,7,12,6};
        //System.out.println(bfsSolution(array));
        System.out.println(findLongestBand(array));
    }

    /*
    Time Complexity : O(N*logN)
     */
    public static int bfsSolution(int[] arr) {
        int longestBand = 0;

        Arrays.sort(arr);
        int count = 0;

        for(int i = 1; i < arr.length; i++) {
            if((Math.abs(Math.abs(arr[i]) - Math.abs(arr[i-1]))) == 1) {
                count++;
            } else {
                longestBand = Math.max(longestBand, count);
                count = 0;
            }
        }
        return longestBand > 0 ? longestBand + 1 : longestBand;
    }

    /*
    Time Complexity: O(N)
     */
    public static int findLongestBand(int[] arr) {
        if(arr == null)
            return 0;
        int longestBand = 0;
        Set<Integer> integerSet = Arrays.stream(arr).boxed().collect(Collectors.toSet());

        for(int a : arr) {
            int parent = a - 1;
            if(!integerSet.contains(parent)) {
                int next_no = a + 1;
                int cnt = 1;

                while (integerSet.contains(next_no)) {
                    cnt++;
                    next_no++;
                }
                longestBand = Math.max(longestBand, cnt);
            }
        }

        return longestBand;
    }
}
