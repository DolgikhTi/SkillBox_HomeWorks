import java.util.Scanner;

public class Main
{
  public static void main(String[] args)
  {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      String number = input.replaceAll("[^0-9]", "");
      if (number.length() > 11 || number.length() < 10) {
        System.out.println("Неверный формат номера");
      } else {
        if (number.length() == 10) {
          String number2 = number.replaceAll("^", "7");
          System.out.println(number2);
        } else {
          if (number.matches("^7\\d+")) {
            System.out.println(number);
          } else {
            if (number.matches("^8\\d+")) {
              String number3 = number.replaceAll("8", "7");
              System.out.println(number3);
            } else {
              System.out.println("Неверный формат номера");
            }
          }
        }
      }
    }
  }

}

