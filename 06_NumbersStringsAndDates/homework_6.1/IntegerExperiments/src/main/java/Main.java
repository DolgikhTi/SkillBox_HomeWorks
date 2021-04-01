public class Main {

  public static void main(String[] args) {
    Container container = new Container();
    container.count += 7853;

    int sum = sumDigits(7853);

    System.out.println(sum);
  }

  /* Реализуйте метод sumDigits который возвращает сумму цифр числа, пример:
  передано 12345, метод должен вернуть 15
  если передано null, то должен вернуть -1

  Запустите тесты TestSumDigits для проверки корректности работы метода

  не меняйте название метода, его возвращаемое значение и модификаторы доступа (public).
  В противном случае тестовый метод не сможет проверить ваш код
   */

  //public static int sumDigits(Integer number)
  //{
    //@TODO: write code here
    //String s = Integer.toString(number);
    //Integer sum = 0;
    //for (int i = 0; i < s.length(); i++) {
     // sum += Integer.parseInt(String.valueOf(s.charAt(i)));
    //}
    //return sum;
  //}

  public static int sumDigits(Integer number)
  {
    String s = Integer.toString(number);
    char[] chars = s.toCharArray();
    int sum = 0;

    for (int i = 0; i < chars.length; i++){
      sum = sum + Character.getNumericValue(chars[i]);
    }
    return sum;
  }
}
