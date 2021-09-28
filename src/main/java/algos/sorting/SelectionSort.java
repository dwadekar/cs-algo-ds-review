package algos.sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int [] array = {21, 4, 12, 6, 8, 2, 12,7};

        printArray(array);
        selectionSort(array);
        System.out.println("\n");
        printArray(array);
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

    public static void selectionSort(int [] array) {
        for (int i = 0; i < array.length; i++) {
            int index = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j] <= array[index])
                    index = j;
            }
            //if(index != i)
                swap(array, i, index);
        }
    }
}
