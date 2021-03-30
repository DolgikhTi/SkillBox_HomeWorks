package ru.skillbox;

public class Computer
{
    public static String vendor;
    public static String name;

    public Computer(String vendor, String name)
    {
        this.vendor = vendor;
        this.name = name;
    }

    public static int calculateWeight(){
        CPU cpu = new CPU(0, 0, "", 0);
        RAM ram = new RAM("", 0, 0);
        System.out.println("Общая масса компьютера: " + cpu.getWeight() + ram.getWeight());
        return calculateWeight();
    }

    public String toString()
    {
        CPU cpu = new CPU(0, 0, "", 0);
        RAM ram = new RAM("", 0, 0);
        System.out.println(cpu);
        System.out.println(ram);
        return toString();
    }
}
