package ds.arrays;

/*
Problem Statement: Implement a function that takes arrays of integers, and returns array of the same length
where each element in the output array is equal to the product of every other number in the input array.
Solve problem without using division.

Input: array={1,2,3,4,5}
Output = [120,60,40,30,24]
Pattern:

BFS Solution: Use two loops and find out product with each element.
But time complexity is O(N*N)
 */
public class ArrayOfProducts {
    public static void main(String[] args) {
        int[] array={1,2,3,4,5};
        int[] products = arrayOfProducts(array);
        for(int a : products){
            System.out.print(a + ",");
        }
    }

    /*
    Time Complexity : O(N)
    Space Complexity : O(N)
     */
    public static int[] arrayOfProducts(int[] arr) {
        if(arr == null || arr.length == 1)
            return arr;
        int[] products = new int[arr.length];

        for(int i = 0; i < arr.length; i++)
            products[i] = 1;

        int temp = 1;

        for(int i = 0; i < arr.length; i++) {
            products[i] = temp;
            temp *= arr[i];
        }
        temp = 1;
        for(int i = arr.length - 1; i >= 0; i--) {
            products[i] *= temp;
            temp *= arr[i];
        }

        return products;
    }
}
