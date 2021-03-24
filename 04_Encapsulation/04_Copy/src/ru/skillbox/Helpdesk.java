package ru.skillbox;

public class Helpdesk
{
    private final double weight;
    private final String deliveryAddress;
    private final boolean possibleToFlip;
    private final String registrationNumber;
    private final boolean fragileCargo;

    public Helpdesk(double weight, String deliveryAddress, boolean possibleToFlip,
                    String registrationNumber, boolean fragileCargo)
    {
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.possibleToFlip = possibleToFlip;
        this.registrationNumber = registrationNumber;
        this.fragileCargo = fragileCargo;
    }

    public double getWeight()
    {
        return weight;
    }

    public String getDeliveryAddress()
    {
        return deliveryAddress;
    }

    public boolean isPossibleToFlip()
    {
        return possibleToFlip;
    }

    public String getRegistrationNumber()
    {
        return registrationNumber;
    }

    public boolean isFragileCargo()
    {
        return fragileCargo;
    }

    public Helpdesk setDeliveryAddress(String deliveryAddress)
    {
        return new Helpdesk(weight, deliveryAddress, possibleToFlip, registrationNumber, fragileCargo);
    }

    public Helpdesk setWeight(double weight)
    {
        return new Helpdesk(weight, deliveryAddress, possibleToFlip, registrationNumber, fragileCargo);
    }
}
