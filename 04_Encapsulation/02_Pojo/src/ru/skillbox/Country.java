package ru.skillbox;

public class Country {
    private String nameCountry;
    private int population;
    private double countryArea;//км2
    private String nameCapital;
    private boolean outletToTheSea;

    public Country(String nameCountry)
    {
        this.nameCountry = nameCountry;
    }

    public void setNameCountry(String nameCountry)
    {
        this.nameCountry = nameCountry;
    }

    public String getNameCountry()
    {
        return nameCountry;
    }

    public void setPopulation(int population)
    {
        this.population = population;
    }

    public int getPopulation()
    {
        return population;
    }

    public void setCountryArea(double countryArea)
    {
        this.countryArea = countryArea;
    }

    public double getCountryArea()
    {
        return countryArea;
    }

    public void setNameCapital(String nameCapital)
    {
        this.nameCapital = nameCapital;
    }

    public String getNameCapital()
    {
        return nameCapital;
    }

    public void setOutletToTheSea(boolean outletToTheSea)
    {
        this.outletToTheSea = outletToTheSea;
    }

    public boolean isOutletToTheSea()
    {
        return outletToTheSea;
    }
}
