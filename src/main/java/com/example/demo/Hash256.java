package com.example.demo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash256 {
    public static String hash(String string) {

        // get an instance of the SHA-256 message digest algorithm
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // compute the hash of the input string
            byte[] hash = md.digest(string.getBytes());

            // convert the hash to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }

            // print the hash
            return hexString.toString();
        }
        catch (NoSuchAlgorithmException e) {
            return "";
        }


    }
}
