package calculator;

import java.util.Scanner;

import static calculator.Operations.getResult;


public class Calculator {

    static Operations operations = new Operations();

    public static void startCalculator() {
        getMathExcample();
    }

    public static void getMathExcample() {
        System.out.print("Enter numbers: ");
        Scanner scanner = new Scanner(System.in);
        String[] splitNextLine = scanner.nextLine().split(" ");

        float firstNumb = Integer.parseInt(splitNextLine[0]);
        float secondNumb = Integer.parseInt(splitNextLine[2]);

        chooseSign(firstNumb, splitNextLine[1], secondNumb);
    }

    public static void chooseSign(float firstNumb, String sign, float secondNumb) {
        switch (sign) {
            case "+" -> getResult(operations.add(firstNumb, secondNumb));
            case "-" -> getResult(operations.subtract(firstNumb, secondNumb));
            case "*" -> getResult(operations.multiply(firstNumb, secondNumb));
            case "/" -> getResult(operations.divide(firstNumb, secondNumb));
        }
    }
}
