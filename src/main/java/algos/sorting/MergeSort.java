package algos.sorting;

public class MergeSort {
    private static int[] mergeArray;
    private static int[] tempArray;

    public MergeSort(int[] array) {
        this.mergeArray = array;
        this.tempArray = new int[array.length];
    }

    public static void main(String[] args) {
        int [] array = {21, 4, 12, 6, 8, 2, 12};
        MergeSort mergeSort = new MergeSort(array);

        printArray(mergeArray);
        mergeSort( 0, array.length - 1);
        System.out.println("\n");
        printArray(mergeArray);
    }

    private static void mergeSort(int low, int high) {
        if(low >= high) return;

        int middle = (low + high)/2;
        mergeSort(low, middle);
        mergeSort(middle + 1, high);

        merge(low, middle, high);
    }

    private static void merge(int low, int middle, int high) {
        for (int i = low; i <= high; i++)
            tempArray[i] = mergeArray[i];

        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (tempArray[i] <= tempArray[j]) {
                mergeArray[k] = tempArray[i];
                i++;
            } else {
                mergeArray[k] = tempArray[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            mergeArray[k] = tempArray[i];
            i++;
            k++;
        }

        while (j <= high) {
            mergeArray[k] = tempArray[j];
            j++;
            k++;
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
