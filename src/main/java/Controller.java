import Helpers.Actions;

public class Controller {
    Actions ac = new Actions();
    int firstNum;
    int secondNum;
    char operation;
    String result;

    public void getResult(){
        System.out.println("Enter first number:");
        firstNum = ac.getNumber();
        System.out.println("Enter second number:");
        secondNum = ac.getNumber();
        System.out.println("Enter an operation:");
        operation = ac.getOperation();
        result = ac.calculator(firstNum,secondNum,operation);
        System.out.println("Your result is: " + result);
    }
}
