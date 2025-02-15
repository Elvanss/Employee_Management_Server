package com.management.employee.util;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Validator {
    private static Matcher matcher = null;
    private static Pattern pattern = null;

    private Validator() {
    }

    public boolean isEmptyString(String s){
        return s == null || s.isBlank();
    }
    public boolean notIncludeDigits(String s) {
        pattern = Pattern.compile(com.management.employee.constant.Pattern.NO_DIGITS_PATTERN);
        matcher = pattern.matcher(s);
        return matcher.matches();
    }
    public boolean isEmail(String email) {
        pattern = Pattern.compile(com.management.employee.constant.Pattern.EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public boolean isPassword(String password){
        pattern = Pattern.compile(com.management.employee.constant.Pattern.PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
