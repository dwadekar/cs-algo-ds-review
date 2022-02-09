package ds.arrays;

/*
Problem Statement: Implement a function that takes an input a vector of integers and prints maximum subarray
sum that can be formed. A subarray is defined as consecutive segment of the array.
If all numbers are negative, then return 0.

Input: array={-1, 2,3,4,-2,6, -8,3}
Output = 13
Pattern: Kadane's algorithm
 */
public class MaximumSum {
    public static void main(String[] args) {
        int[] array={-1, 2,3,4,-2,6, -8,3};
        System.out.println(maximumArray(array));
        System.out.println(maximumArray(new int[]{-1, -2, -3}));
    }

    public static int maximumArray(int[] array) {
        int maximum_so_far = Integer.MIN_VALUE;
        int maximum_ending_here = 0;

        for (int j : array) {
            maximum_ending_here = maximum_ending_here + j;
            if (maximum_so_far < maximum_ending_here)
                maximum_so_far = maximum_ending_here;
            if (maximum_ending_here < 0)
                maximum_ending_here = 0;
        }

        return Math.max(maximum_so_far, 0);
    }
}
