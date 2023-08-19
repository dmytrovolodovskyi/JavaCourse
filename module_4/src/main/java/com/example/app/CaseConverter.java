package com.example.app;

import java.util.Scanner;

public class CaseConverter {

    public void startProgram(){
        String userText = getUserText();
        String[] splitText = splitUserText(userText);
        String textInCase = setTextCase(splitText);
        System.out.println("Result: " + textInCase);
    }

    public String getUserText() {
        System.out.print("Enter some text: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String[] splitUserText(String text) {
        return text.split("");
    }

    public String setTextCase(String[] splitText) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < splitText.length; i++) {
            if (i % 2 == 0) stringBuilder.append(splitText[i].toLowerCase());
            else stringBuilder.append(splitText[i].toUpperCase());
        }
        return String.valueOf(stringBuilder);
    }
}
