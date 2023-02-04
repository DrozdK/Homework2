package Helpers;

import java.util.Scanner;

public class Actions {
    static Scanner sc = new Scanner(System.in);

    public int getNumber() {
        int number;
        if (sc.hasNextInt()) {
            number = sc.nextInt();
        } else {
            System.out.println("Incorrect value. Try again");
            sc.next();
            number = getNumber();
        }
        return number;
    }

    public static char getOperation() {
        char operation;
        operation = sc.next().charAt(0);
        return operation;
    }

    public static String calculator(int fistNum, int secondNum, char operation) {
        String result;
        switch (operation) {
            case '+':
                result = Operations.addition(fistNum, secondNum);
                break;
            case '-':
                result = Operations.subtract(fistNum, secondNum);
                break;
            case '*':
                result = Operations.multiplication(fistNum, secondNum);
                break;
            case '/':
                if (secondNum == 0) {
                    System.out.println("You can't divide by zero. Try again" + "\n"
                            + "Enter second number:");
                    secondNum = sc.nextInt();
                }
                result = Operations.divide(fistNum, secondNum);
                break;
            default:
                System.out.println("Invalid operation.Valid values are: \"+\", \"-\", \"*\", \"/\". Try again");
                result = calculator(fistNum, secondNum, getOperation());
        }
        return result;
    }
}