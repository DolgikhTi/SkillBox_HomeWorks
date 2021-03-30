package ru.skillbox;

public class RAM
{
    private final String type;
    private final double amount;
    private final double weight;

    public RAM(String type, double amount, double weight)
    {
        this.type = type;
        this.amount = amount;
        this.weight = weight;
    }

    public String getType()
    {
        return type;
    }

    public RAM setType(String type)
    {
        return new RAM(type, amount, weight);
    }

    public double getAmount()
    {
        return amount;
    }

    public RAM setAmount(double amount)
    {
        return new RAM(type, amount, weight);
    }

    public double getWeight()
    {
        return weight;
    }

    public RAM setWeight(double weight)
    {
        return new RAM(type, amount, weight);
    }
}
