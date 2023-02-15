package com.example.cardcontroller;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class CardTokenGenerator {
    private static final String ALGORITHM = "AES";
    private static final byte[] KEY = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

    public static String generateToken(String cardNumber) throws Exception {
        Key key = new SecretKeySpec(KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(cardNumber.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

}
