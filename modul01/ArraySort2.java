package platform.kata.academy.modul01;

import java.util.Arrays;

public class ArraySort2 {
    public static void main(String[] args) {
        int[] a1 = new int[]{1, 1};
        int[] a2 = new int[]{1, 1, 1};
        System.out.println(Arrays.toString(mergeArrays(a1, a2)));
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {

        if (a1 == null || a1.length == 0) {

            return (a2 != null) ? a2 : new int[0];

        } else if (a2 == null || a2.length == 0) {

            return a1;
        }

        int position;

        for (int key : a2) {
            position = Arrays.binarySearch(a1, key);
            if (position < 0) {
                position = Math.abs(position + 1);
            }
            int shift = a1.length - position;
            int[] temp = Arrays.copyOf(a1, a1.length + 1);
            if (shift >= 0) {
                System.arraycopy(a1, position, temp, position + 1, shift);
            }
            temp[position] = key;
            a1 = Arrays.copyOf(temp, a1.length + 1);
        }

        return a1;
    }

}
