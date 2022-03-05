package platform.kata.academy.modul01;

import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        int[] a1 = new int[]{1, 2};
        int[] a2 = new int[]{1, 4, 5};
        System.out.println(Arrays.toString(mergeArrays(a1, a2)));
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        if (a1 == null || a1.length == 0) {

            return (a2 != null) ? a2 : new int[0];

        } else if (a2 == null || a2.length == 0) {

            return a1;
        }
        int[] result = new int[a1.length + a2.length];

        int lengthA1 = 0;
        int lengthA2 = 0;
        int lengthResult = 0;
        while (lengthA1 < a1.length && lengthA2 < a2.length) {

            result[lengthResult++] = (a1[lengthA1] < a2[lengthA2]) ? a1[lengthA1++] : a2[lengthA2++];

        }
        if (lengthA1 == a1.length) {
            while (lengthA2 < a2.length) {
                result[lengthResult++] = a2[lengthA2++];
            }
        } else {
            while (lengthA1 < a1.length) {
                result[lengthResult++] = a1[lengthA1++];
            }
        }
        return result;
    }
}
