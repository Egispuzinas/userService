package com.userService.userService.services;

import java.util.Random;

public class OtpGenerator {
    private String otp = "";

    public String getOtp() {
        String numbers = "0123456789";
        int numberLength = numbers.length();
        int otpLength = 4;
        Random random = new Random();

        for (int i = 0; i < otpLength; i++) {
            otp += numbers.charAt(random.nextInt(numberLength));
        }
        return otp;
    }
}
