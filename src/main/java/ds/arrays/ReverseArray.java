package ds.arrays;

public class ReverseArray {

    public static void main(String[] args) {
        int [] arrInt = {1, 2, 3, 4, 5};
        //int [] arrInt = null;

        //reverseSol1(arrInt);

        if(arrInt != null) {
            System.out.println("Before reversing: ");

            for (int i =0; i < arrInt.length; i++) {
                System.out.println(arrInt[i]);
            }

            //reverseSol1(arrInt);
            reverseSol2(arrInt);

            System.out.println("After reversing: ");

            for (int i =0; i < arrInt.length; i++) {
                System.out.println(arrInt[i]);
            }
        }
    }

    public static void reverseSol1(int [] arr) {
        int temp;

        if(arr == null || arr.length == 0)
            return;

        int startIndex = 0;
        int endIndex = arr.length - 1;

        while (startIndex < endIndex) {
            temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;

            startIndex+=1;
            endIndex-=1;
        }
    }

    public static void reverseSol2(int [] arr) {
        if(arr == null || arr.length == 0)
            return;

        int temp;

        for(int i = 0; i < arr.length/2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
}
