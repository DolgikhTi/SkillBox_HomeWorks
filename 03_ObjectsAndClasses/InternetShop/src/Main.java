public class Main {
    public static void main(String[] args)
    {
        Basket vasyaBasket = new Basket();
        vasyaBasket.add("Молоко", 87, 2);
        vasyaBasket.add("Хлеб", 36, 3);
        vasyaBasket.add("Яблоки", 180, 6);

        Basket petyaBasket = new Basket(10080);
        petyaBasket.add("Лопата", 370,2);
        petyaBasket.add("Бочка", 3400,1);

        vasyaBasket.print("Корзина Васи: ");
        petyaBasket.print("Корзина Пети: ");

        System.out.println();
        System.out.println("Количество товаров, при добавлении нового товара: " +
                Basket.getTotalAmountProductAllBaskets());
        System.out.println("Стоимость товаров, при добавлении нового товара: " +
                Basket.getTotalPriceProductAllBaskets());
        System.out.println("Средняя стоимость товаров во всех корзинах:" + Basket.averagePrice());
        System.out.println("Средняя стоимость корзины:" + Basket.averagePriceBasket());
    }
}
