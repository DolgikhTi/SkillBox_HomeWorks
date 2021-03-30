package ru.skillbox;

public class CPU
{
    private final double frequency;
    private final int quantityCores;
    private final String producer;
    private final double weight;

    public CPU(double frequency, int quantityCores, String producer, double weight)
    {
        this.frequency = frequency;
        this.quantityCores = quantityCores;
        this.producer = producer;
        this.weight = weight;
    }

    public double getFrequency()
    {
        return frequency;
    }

    public CPU setFrequency(double frequency)
    {
        return new CPU(frequency, quantityCores, producer, weight);
    }

    public int getQuantityCores()
    {
        return quantityCores;
    }

    public CPU setQuantityCores(int quantityCores)
    {
        return new CPU(frequency, quantityCores, producer, weight);
    }

    public String getProducer()
    {
        return producer;
    }

    public CPU setProducer(String producer)
    {
        return new CPU(frequency, quantityCores, producer, weight);
    }

    public double getWeight()
    {
        return weight;
    }

    public CPU setWeight(double weight)
    {
        return new CPU(frequency, quantityCores, producer, weight);
    }
}
