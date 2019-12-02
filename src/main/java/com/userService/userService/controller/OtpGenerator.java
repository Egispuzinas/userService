package com.userService.userService.controller;

import com.userService.userService.entities.User;

import java.util.Arrays;
import java.util.Random;

public class OtpGenerator {
    private char[] otp;

    public String getOtp() {
        String numbers = "0123456789";
        int numberLength = numbers.length();
        int otpLength = 4;
        Random random = new Random();
        char[] otp = new char[otpLength];

        for (int i = 0; i < otpLength; i++) {
            otp[i] = numbers.charAt(random.nextInt(numberLength));
        }
        return otp.toString();
    }

    @Override
    public String toString() {
        return Arrays.toString(otp);
}
}
