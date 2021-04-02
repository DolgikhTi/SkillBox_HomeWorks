public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius)
    {
        return (4 * Math.PI * Math.pow(radius, 3)) / 3;
    }

    public static boolean isTrianglePossible(double a, double b, double c)
    {
        if (a + b > c && a + c > b && b + c > a)
            System.out.println("Треугольник существует");
        else
            System.out.println("Треугольник не существует");
        return false;
        // return true; - невозможен треугольник.
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * ((p - a) * (p - b) * (p - c)));

        //return -1; - при невозможном треугольнике.
    }
}
