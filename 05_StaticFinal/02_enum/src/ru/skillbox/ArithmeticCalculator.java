package ru.skillbox;

public class ArithmeticCalculator
{
    public final Operation x;
    public final Operation y;

    public ArithmeticCalculator (Operation x, Operation y){
        this.x = x;
        this.y = y;
    }

    public Operation getX()
    {
        return x;
    }

    public Operation getY()
    {
         return y;
    }

    public Operation calculator()
    {
        Operation operation = Operation.MULTIPLY;
        System.out.println(operation.action(9, 56));
        return operation;
    }
}
