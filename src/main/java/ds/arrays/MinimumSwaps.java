package ds.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Problem Statement: Given an array of size N, find minimum number of swaps needed to make an array as sorted.

Input: array={5,4,3,2,1}
Output = 2
Pattern: Two pointer algorithm
 */
public class MinimumSwaps {
    public static void main(String[] args) {
        int[] array={5,4,3,2,1};
        int numOfSwaps = findMinSwaps(array);
        System.out.println("Number of Swaps required: "+ numOfSwaps);
    }

    public static int findMinSwaps(int[] arr) {
        if(arr == null || arr.length == 0)
            return 0;
        Map<Integer, Integer> nums = new HashMap<>();
        int ans = 0;

        for(int i = 0; i < arr.length; i++)
            nums.put(arr[i], i);

        Arrays.sort(arr);

        boolean[] visited = new boolean[arr.length];
        Arrays.fill(visited, false);

        for(int i = 0; i < arr.length; i++) {
            if(visited[i] && i == nums.get(arr[i]))
                continue;
            int cnt = 0;
            int j = i;
            while(!visited[j]) {
                visited[j] = true;
                j = nums.get(arr[j]);
                cnt++;
            }
            if(cnt > 0)
                ans += cnt - 1;
        }
        return ans;
    }
}
