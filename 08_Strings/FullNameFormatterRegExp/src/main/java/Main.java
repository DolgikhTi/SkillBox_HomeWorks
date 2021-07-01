import java.util.Scanner;

public class Main {

  private static final String REGEX_SPLIT_FULL_NAME = "(([А-Я][а-я]+)(-[А-Я][а-я]+)?\\s+){2}(([А-Я][а-я]+)(\\s+[а-я]+)?)";

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО

      if (input.matches(REGEX_SPLIT_FULL_NAME)) {
        String[] fio = input.split("\\s+");
        System.out.println("Фамилия: " + fio[0]);
        System.out.println("Имя: " + fio[1]);
        System.out.println("Отчество: " + fio[2]);
      } else {
        System.out.println("Введенная строка не является ФИО");
      }
    }
  }

}