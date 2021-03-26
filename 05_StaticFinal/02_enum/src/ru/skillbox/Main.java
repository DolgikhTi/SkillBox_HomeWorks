package ru.skillbox;

public class Main {
    public static void main(String[] args)
    {
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator(Operation.ADD, Operation.SUBTRACT);
        System.out.println(arithmeticCalculator.calculator());
    }
}

