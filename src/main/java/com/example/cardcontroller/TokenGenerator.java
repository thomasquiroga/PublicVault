package com.example.cardcontroller;
import java.security.SecureRandom;
import java.util.Base64;

public class TokenGenerator {

    private static final int TOKEN_LENGTH = 16;
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final Base64.Encoder ENCODER = Base64.getUrlEncoder().withoutPadding();

    public static String generateToken(String cardNumber) {
        byte[] tokenBytes = new byte[TOKEN_LENGTH];
        RANDOM.nextBytes(tokenBytes);
        return ENCODER.encodeToString(tokenBytes);
    }
}


