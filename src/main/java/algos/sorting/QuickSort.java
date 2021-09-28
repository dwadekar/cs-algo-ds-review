package algos.sorting;

public class QuickSort {
    public static void main(String[] args) {
        int [] array = {21, 4, 12, 6, 8, 2, 12};

        printArray(array);
        quickSort(array, 0, array.length - 1);
        System.out.println("\n");
        printArray(array);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low >= high) return;
        int pivot = partition(array, low, high);
        quickSort(array, low, pivot - 1);
        quickSort(array, pivot + 1, high);
    }

    private static int partition(int[] array, int low, int high) {
        int pivotIndex = (low + high)/2;
        swap(array, pivotIndex, high);
        int i = low;

        for (int j = low; j < high; j++) {
            if (array[j] <= array[high]) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, high);
        return i;
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
