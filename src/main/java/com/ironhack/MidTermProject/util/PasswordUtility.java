package com.ironhack.MidTermProject.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Random;

public class PasswordUtility {

    public static String randomPasswordGenerator() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println("This is the password: " + generatedString);
        return generatedString;
    }

    public static String main() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String result = passwordEncoder.encode(randomPasswordGenerator());
        System.out.println("This is the hashed password: " + result);
        return result;
    }
}

