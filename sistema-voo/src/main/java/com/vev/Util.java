package com.vev;

import java.util.ArrayList;
import java.util.Random;

public class Util {

    public Util() {
    }
    
    public String generateId(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }

        return sb.toString();
    }

    public String encapsulaString(String str, int fullLength) {
        String[] lines = new String[1];

        if (str.contains("\n")) {
            lines = str.split("\n");
        } else {
            lines[0] = str;
        }

        ArrayList<String> finalStringArray = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();

        String top = new String(new char[fullLength - 2]).replace('\0', '\u2550');
        top = "\u2554" + top + "\u2557";

        String bottom = new String(new char[fullLength - 2]).replace('\0', '\u2550');
        bottom = "\u255a" + bottom + "\u255d";

        finalStringArray.add(top);

        for (String line : lines) {
            String finalLine = encapsulaLinha(line, fullLength - 2);
            finalStringArray.add(finalLine);
        }

        finalStringArray.add(bottom);

        for (int i = 0; i < finalStringArray.size(); i++) {
            String line = finalStringArray.get(i);
            builder.append(line);
            if (i < finalStringArray.size() - 1) {
                builder.append("\n");
            }
        }

        return builder.toString();
    }

    private String encapsulaLinha(String line, int fullLength) {
        int missingSpaces = fullLength - line.length() - 1;
        String spaces = new String(new char[missingSpaces]).replace('\0', ' ');
        return "\u2551 " + line + spaces + "\u2551";
    }

}
