package ru.skillbox;

public class TV {
    private String name;
    private int price;
    private int screenSize; //дюйм
    private boolean color;

    public TV(String name, int price)
    {
        this.name = name;
        this.price = price;
    }

    public void setName(String name)
    {
        this.name = name;
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

    public void setScreenSize(int screenSize)
    {
        this.screenSize = screenSize;
    }

    public int getScreenSize()
    {
        return screenSize;
    }

    public void setColor(boolean color)
    {
        this.color = color;
    }

    public boolean isColor()
    {
        return color = color;
    }
}
