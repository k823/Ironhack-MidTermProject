package com.ironhack.MidTermProject.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Random;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

public class PasswordUtility {

    public static String randomPasswordGenerator() {
        LOGGER.info("GENERATING RANDOM PASSWORD.");
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

    public static String main() {
        LOGGER.info("ENCODING PASSWORD.");
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String result = passwordEncoder.encode(randomPasswordGenerator());
        LOGGER.info("ENCODED PASSWORD IS: " + LOGGER);
        return result;
    }
}

