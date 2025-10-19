package calculator;

import calculator.Controller.StringController;

public class Application {
    public static void main(String[] args) {
        StringController calculator =  new StringController();
        try {
            calculator.StartProcess();
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}