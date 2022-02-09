package ds.arrays;

/*
Problem Statement: Given N non-negative integers representing an elevation map where the width of each bar is 1.
compute how much water it can trap after raining

Input: height={0,1,0,2,1,0,1,3,2,1,2,1}
Output = 6
Pattern: Determining the maximum with each iteration from left and right of an array
 */
public class RainWaterTrap {
    public static void main(String[] args) {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(bfsSolution(height));
        System.out.println(findRainWaterTrap(height));
    }

    /*
    Time Complexity: O(N*N)
     */
    public static int bfsSolution(int[] heights) {
        int waterTrapped = 0;

        for(int i = 1; i < heights.length - 1; i++) {
            int j = i-1;
            int k = i+1;
            int maxLeft = 0;
            while(j>=0) {
                maxLeft = Math.max(maxLeft, heights[j]);
                j--;
            }
            int maxRight = 0;
            while(k<=heights.length - 1) {
                maxRight = Math.max(maxRight, heights[k]);
                k++;
            }
            int val = Math.min(maxLeft, maxRight) - heights[i];
            waterTrapped += Math.max(val, 0);
        }

        return waterTrapped;
    }

    /*
    Time Complexity: O(N)
     */
    public static int findRainWaterTrap(int[] heights) {
        int n = heights.length;
        int waterTrapped = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = heights[0];
        right[n-1] = heights[n-1];

        for(int i = 1; i < n; i++) {
            left[i] = Math.max(left[i-1], heights[i]);
            right[n-i-1] = Math.max(right[n-i], heights[n-i-1]);
        }

        for(int i = 0; i< n; i++) {
            waterTrapped += Math.min(left[i], right[i]) - heights[i];
        }

        return waterTrapped;
    }
}
