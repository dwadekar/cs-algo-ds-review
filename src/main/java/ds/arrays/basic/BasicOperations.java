package ds.arrays.basic;

import org.apache.commons.lang3.ArrayUtils;

public class BasicOperations {

    public static void main(String[] args) {
        int[] intArray = new int[10]; //Initialization of an array

        intArray[0] = 10;
        intArray[1] = 3;
        intArray[2] = -1;
        intArray[3] = 4;
        intArray[4] = 2;

        for (int j : intArray) {
            System.out.println(j);
        }
        System.out.println("----------------------------");

        intArray = insert_element(5, intArray, 35);
        intArray = insert_element(7, intArray, 21);
        intArray = insert_element(9, intArray, 17);
        intArray = insert_element(8, intArray, 11);

        for (int j : intArray) {
            System.out.println(j);
        }
        System.out.println("------------Update Operation----------------");
        update_element(2, intArray, 34);
        update_element(13, intArray, 24);
        update_element(10, intArray, 40);
        for (int j : intArray) {
            System.out.println(j);
        }

        System.out.println("------------Delete Operation----------------");
        intArray = remove_element(intArray, 13);
        System.out.println("Array size : " + intArray.length);
        for (int j : intArray) {
            System.out.println(j);
        }
    }

    public static int[] insert_element(int position, int[] array, int element) {
        if (array == null)
            return null;

        int[] result = new int[array.length + 1];
        for (int i = 0; i < result.length; i++) {
            if (i < position - 1)
                result[i] = array[i];
            else if (i == position - 1)
                result[i] = element;
            else
                result[i] = array[i - 1];
        }
        return result;
    }

    public static int[] update_element(int position, int[] array, int element) {
        if (array == null)
            return null;

        if(position >= 0 && position < array.length) {
            array[position] = element;
        } else {
            throw new ArrayIndexOutOfBoundsException("Index: " + position + " does not exist for array with length: " + array.length);
        }
        return array;
    }

    public static int[] remove_element(int[] array, int position) {
        if(array == null)
            return array;
        else if(position >= 0 && position < array.length) {
            int[] newArray = new int[array.length - 1];
            System.arraycopy(array, 0, newArray, 0, position);
            System.arraycopy(array, position + 1, newArray, position, array.length - position - 1);
            return newArray;
        } else {
            throw new ArrayIndexOutOfBoundsException("Index: " + position + " does not exist for array with length: " + array.length);
        }
    }
}
