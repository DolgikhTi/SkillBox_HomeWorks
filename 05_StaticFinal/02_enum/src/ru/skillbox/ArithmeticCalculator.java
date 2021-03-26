package ru.skillbox;

public class ArithmeticCalculator
{
    public static int x = 65;
    public static int y = 23;

    public ArithmeticCalculator(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public static void calculate(int x, int y)
    {
        Operation operation1 = Operation.ADD;

        System.out.println(operation1);
    }
}

