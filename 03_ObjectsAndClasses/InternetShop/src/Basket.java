public class Basket
{

        private static String items = "";
        private static int totalWeight = 0;

        public static void main(String[] args)
        {
            add("Колбаса",52,76, 4);
            add("Молоко", 87, 55, 3);
            add("Масло", 200,  120, 5);
            print("Содержимое корзины:");
            int totalWeight = getTotalWeight();
            System.out.println("Общий вес товаров: " + totalWeight);
            clear();
            System.out.println();
            print("Содержимое корзины:");
            totalWeight = getTotalWeight();
            System.out.println("Общий вес товаров: " + totalWeight);
        }

        public static void add(String name, int price)
        {
            add(name, price, 1);
        }

        public static void add(String name, int price, int weight)
        {
            add(name, weight, price, 1);
        }

        public static void add (String name, int price, int weight, int count)
        {
            items = items + "\n" + name + " - " +
                    count + "шт. - " + weight + "г. - " + price;
            totalWeight = totalWeight + count * weight;
        }

        public static void clear()
        {
            items = "";
            totalWeight = 0;
        }

        public static int getTotalWeight()
        {
            return totalWeight;
        }

        public static void print(String title)
        {
            System.out.println(title);
            if (items.isEmpty())
            {
                System.out.println("Корзина пуста");
            }
            else
            {
                System.out.println(items);
            }
        }
}
