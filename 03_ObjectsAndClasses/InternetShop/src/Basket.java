public class Basket
{

        private String items = "";
        private int totalPrice = 0;
        private int limit;

        private static int totalPriceProductAllBaskets = 0;
        private static int totalAmountProductAllBaskets = 0;

        public Basket()
        {
            items = "Список товаров:";
            this.limit = 100000;
        }

        public Basket(int totalPriceLimit)
        {
            this();
            limit = totalPriceLimit;
        }

        public void add (String name, int price, int amount)
        {
            if (totalPrice + price >= limit)
            {
                return;
            }
            items = items + "\n" + name + " - " + price +"р." +  "-" + amount + "шт.";
            totalPrice = totalPrice + price;
            totalPriceProductAllBaskets = totalPriceProductAllBaskets + price;
            totalAmountProductAllBaskets = totalAmountProductAllBaskets + amount;
        }

        public static double averagePrice()
        {
            double averagePriceAllBaskets = Basket.getTotalPriceProductAllBaskets() /
                    Basket.getTotalAmountProductAllBaskets();
            return averagePriceAllBaskets;
        }

        public static double averagePriceBasket()
        {
            double averagePriceBasket = Basket.getTotalPriceProductAllBaskets() /
                    2;
            return averagePriceBasket;
        }

        public static int getTotalPriceProductAllBaskets()
        {
            return totalPriceProductAllBaskets;
        }
        public static int getTotalAmountProductAllBaskets()
        {
            return totalAmountProductAllBaskets;
        }
        public void clear()
        {
            items = "";
            totalPrice = 0;
        }

        public int getTotalPrice()
        {
            return totalPrice;
        }

        public void print(String title)
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
