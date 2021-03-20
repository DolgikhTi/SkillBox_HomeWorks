public class Arithmetic
{
    private static int x = 140;
    private static int y = 520;

    public Arithmetic(int numberOne, int numberTwo)
    {
        x = numberOne;
        y = numberTwo;
    }
    public static void main(String[] args)
    {
        sum(x, y);
        difference(x, y);
        products(x, y);
        average(x, y);
        maximum(x, y);
        minimum(x, y);
    }
    private static void sum (int x, int y)
    {
        int z = x + y;
        System.out.println("Сумма чисел: " + z);
    }
    private static void difference(int x, int y)
    {
        int z = x - y;
        System.out.println("Разность чисел: " + z);
    }

    private static void products(int x, int y)
    {
        int z = x * y;
        System.out.println("Произведения чисел: " + z);
    }

    private static void average(double x, double y)
    {
        double z = (x + y) / 2;
        System.out.println("Среднее значение чисел: " + z);
    }

    private static void maximum(int x, int y)
    {
        if (x > y)
        {
        System.out.println("Максимальное значение: " + x);
        }

        if (x < y)
        {
        System.out.println("Максимальное значение: " + y);
        }
    }

    private static void minimum(int x, int y)
    {
        if(x < y)
        {
            System.out.println("Минимальное значение: " + x);
        }

        if(x > y)
        {
            System.out.println("Минимальное значение: " + y);
        }
    }
}
