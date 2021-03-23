package ru.skillbox;

public class Product
{
    private final String name;
    private int price;
    private final boolean barCode;

    public Product(String name, boolean barCode)
    {
        this.name = name;
        this.barCode = barCode;
    }

    public String getName()
    {
        return name;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public int getPrice()
    {
        return price;
    }

    public boolean isBarCode()
    {
        return barCode;
    }
}
