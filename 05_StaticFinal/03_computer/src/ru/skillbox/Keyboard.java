package ru.skillbox;

public class Keyboard
{
    public final String type;
    public final boolean illumination;
    public final double weight;

    public Keyboard(String type, boolean illumination, double weight)
    {
        this.type = type;
        this.illumination = illumination;
        this.weight = weight;
    }

    public String getType()
    {
        return type;
    }

    public boolean isIllumination()
    {
        return illumination;
    }

    public double getWeight()
    {
        return weight;
    }

    public Keyboard setType(String type)
    {
        return new Keyboard(type, illumination, weight);
    }

    public Keyboard setIllumination(boolean illumination)
    {
        return new Keyboard(type, illumination, weight);
    }

    public Keyboard setWeight(double weight)
    {
        return new Keyboard(type, illumination, weight);
    }
}
