package com.example.turing;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class File {
    public static String read(){
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("README"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
            String s = sb.toString();
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";

    }
}
