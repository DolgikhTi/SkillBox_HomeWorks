package ru.skillbox;

public class Screen
{
    public final int diagonal;
    public final ScreenType type;
    public final double weight;

    public Screen(int diagonal, ScreenType type, double weight)
    {
        this.diagonal = diagonal;
        this.type = type;
        this.weight = weight;
    }

    public int getDiagonal()
    {
        return diagonal;
    }

    public ScreenType getType()
    {
        return type;
    }

    public double getWeight()
    {
        return weight;
    }

    public Screen setDiagonal(int diagonal)
    {
        return new Screen(diagonal, type, weight);
    }

    public Screen setType(ScreenType type)
    {
        return new Screen(diagonal, type, weight);
    }

    public Screen setWeight(double weight)
    {
        return new Screen(diagonal, type, weight);
    }
}
