package algos.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int [] array = {21, 4, 12, 6, 8, 2, 12};

        printArray(array);
        insertionSort(array);
        System.out.println("\n");
        printArray(array);
    }

    private static void insertionSort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j-1] > array[j]) {
                swap(array, j, j-1);
                j--;
            }
        }
    }

    private static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }

    private static void swap(int[] array, int j, int i) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
