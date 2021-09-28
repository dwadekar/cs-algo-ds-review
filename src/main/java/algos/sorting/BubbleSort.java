package algos.sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int [] array = {21, 4, 12, 6, 8, 2, 12};

        printArray(array);
        bubbleSort(array);
        System.out.println("\n");
        printArray(array);
    }

    private static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }


    public static void bubbleSort(int [] array) {
        for (int i = 0; i < array.length; i++) {
            for( int j = 0; j < array.length - 1 - i; j++) {
                if(array[j] > array[j+1])
                    swap(array, j, j+1);
            }
        }
    }

    private static void swap(int[] array, int j, int i) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
