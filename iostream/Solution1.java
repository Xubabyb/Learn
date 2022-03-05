package platform.kata.academy.iostream;

import java.io.*;
import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[]{1, 2, 5, 6};
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.out.println(sumOfStream(inputStream));
       /* ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        print(inputStream, byteArrayOutputStream);
        byte[] res = byteArrayOutputStream.toByteArray();
        System.out.println(Arrays.toString(res));*/
    }

    public static int sumOfStream(InputStream inputStream) throws IOException {


        int sum = 0;
        byte [] bytes = inputStream.readAllBytes();
        for (byte temp:bytes) {
            sum+=temp;
        }

        /*
        while (inputStream.available() > 0) {
            int temp = inputStream.read();
            sum = sum + (byte) temp;
        }*/
        return sum;
    }

    public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {
        while (inputStream.available() > 0) {
            byte[] bytes = inputStream.readAllBytes();
            for (byte temp : bytes) {
                if (temp % 2 == 0) {
                    outputStream.write(temp);
                }
            }

        }
        outputStream.flush();
        //System.out.println(outputStream);
    }
}
