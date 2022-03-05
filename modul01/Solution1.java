package platform.kata.academy.modul01;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Solution1 {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        String str = "abracadabra";
        byte [] dig = md.digest("abracadabra".getBytes("UTF-8"));
        for (byte temp:dig){
            System.out.printf("%02x",temp);

        }
        System.out.println();
        System.out.println(0x0bp3);
        System.out.println(4%3);
    }
}
