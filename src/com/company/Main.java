package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String textToEncrypt = null;
        int key = 0;
        String textToDecipher = null;

        System.out.println("Привет! Введи цифру 1, если тебе нужно зашифровать текст или " +
                "введи цифру 2, если нужно расшифровать текст");
        int enterNumber = scanner.nextInt();
        if (enterNumber == 1) {
            caesarCipher(null, key);
        } else if (enterNumber == 2) {
            decipher(textToDecipher);
        } else {
            System.out.println("Нужно ввести только цифры 1 или 2");
        }
    }

    private static String caesarCipher(String textToEncrypt, int key) {
        System.out.println("Введи текст, который нужно зашифровать");
        Scanner scanner = new Scanner(System.in);
        textToEncrypt = scanner.nextLine();
        System.out.println("Введи ключ для шифрования");
        try {
            key = scanner.nextInt();
        } catch (Exception e) {
            throw new InputMismatchException("Нужны только цифры");
        }

        String onlyLetters = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ";
        String newText = "";
        for (int i = 0; i < textToEncrypt.length(); i++) {
            char oneLetter = (char) (textToEncrypt.charAt(i) + key);

            if (oneLetter > onlyLetters.charAt(' ')) {
                newText += (char) (textToEncrypt.charAt(i) - (71 - key));
            } else {
                newText += (char) (textToEncrypt.charAt(i) + key);
            }
        }
        System.out.println(newText);
        return newText;
    }

    private static void decipher(String textToDecipher) {
        String onlyLetters = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ";
        System.out.println("Введи текст, который нужно расшифровать");
        Scanner scanner = new Scanner(System.in);
        textToDecipher = scanner.nextLine();
        for (int i = -50; i < 51; i++) {

            for (char symbol : textToDecipher.toCharArray()) {
                symbol = (char) (symbol - i);
                System.out.print(symbol);
            }

            System.out.println("  - для ключа " + i);
        }
    }
}




