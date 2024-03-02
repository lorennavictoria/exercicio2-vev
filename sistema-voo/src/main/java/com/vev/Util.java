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

    public String encapsulaDetailedToString(String detailedToString) {
        String[] lines = detailedToString.split("\n");
        ArrayList<String> finalStringArray = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();

        finalStringArray.add("\u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557");

        for (String line : lines) {
            String finalLine = encapsulaLinha(line, 42);
            finalStringArray.add(finalLine);
        }

        finalStringArray.add("\u255a\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255d");

        for (int i = 0; i < finalStringArray.size(); i++) {
            String line = finalStringArray.get(i);
            builder.append(line);
            if (i < finalStringArray.size() - 1) {
                builder.append("\n");
            }
        }

        return builder.toString();
    }


    public String encapsulaConfirmacaoReserva(Reserva reserva) {
        String detailedToString = reserva.getVoo().detailedToString();
        String[] lines = detailedToString.split("\n");
        ArrayList<String> finalStringArray = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();

        finalStringArray.add("\u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557");

        finalStringArray.add(encapsulaLinha("VÔO RESERVADO:", 42));
        finalStringArray.add(encapsulaLinha("", 42));

        for (String line : lines) {
            String finalLine = encapsulaLinha(line, 42);
            finalStringArray.add(finalLine);
        }

        finalStringArray.add(encapsulaLinha("", 42));
        finalStringArray.add(encapsulaLinha("Passageiros: " + reserva.getPassageiros(), 42));
        finalStringArray.add(encapsulaLinha("TOTAL: R$" + reserva.getPrecoTotal(), 42));
        finalStringArray.add(encapsulaLinha("Código: " + reserva.getId(), 42));

        finalStringArray.add("\u255a\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255d");

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
        int lineLength = line.length();
        int missingSpaces = fullLength - lineLength - 10;
        String spaces = new String(new char[missingSpaces]).replace('\0', ' ');
        return "\u2551         " + line + spaces + "\u2551";
    }

}
