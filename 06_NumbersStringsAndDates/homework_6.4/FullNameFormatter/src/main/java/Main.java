import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    for (char x = 'a'; x <= 'z'; x++)
    {
      System.out.println(x);
    }

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
    }
  }

}