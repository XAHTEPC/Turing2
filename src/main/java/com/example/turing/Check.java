package com.example.turing;

public class Check {
    public static boolean check_input(String s) {
        boolean fl = true;
        char[] X = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (X[i] < '0' || X[i] > '9')
                fl = false;
        }
        return fl;
    }
}
