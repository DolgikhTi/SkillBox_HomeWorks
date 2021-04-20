import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
      Pattern pattern =Pattern.compile("\\d+");
      Matcher matcher = pattern.matcher(input);
      if (input.equals("0") || input.equals(" ") || input.equals("") || input.equals(null)||matcher.find()) {
        System.out.println("Веденная строка не является ФИО");
      }
    }
  }

}