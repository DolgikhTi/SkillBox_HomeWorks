package ru.skillbox;

public class HardDrive
{
    private final HardDriveType type;
    private final int  amountMemory;
    private final double weight;

    public HardDrive(HardDriveType type, int amountMemory, double weight)
    {
        this.type = type;
        this.amountMemory = amountMemory;
        this.weight = weight;
    }

    public HardDriveType getType()
    {
        return type;
    }

    public int getAmountMemory()
    {
        return amountMemory;
    }

    public double getWeight()
    {
        return weight;
    }

    public HardDrive setType(HardDriveType type)
    {
        return new HardDrive(type, amountMemory, weight);
    }

    public HardDrive setAmountMemory(int amountMemory)
    {
        return new HardDrive(type, amountMemory, weight);
    }

    public HardDrive setWeight(double weight)
    {
        return new HardDrive(type, amountMemory, weight);
    }
}
