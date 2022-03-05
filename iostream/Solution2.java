package platform.kata.academy.iostream;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Solution2 {
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[]{48, 49, 50, 51};
        Charset charset = StandardCharsets.US_ASCII;
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.out.println(readAsString(inputStream, charset));
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, charset));
             StringWriter stringWriter = new StringWriter()) {
            while (reader.ready()) {
                int rd = reader.read();
                stringWriter.write(rd);
            }
            return stringWriter.toString();
        }
    }
}
