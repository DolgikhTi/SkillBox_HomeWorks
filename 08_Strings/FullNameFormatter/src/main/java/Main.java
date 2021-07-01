import java.util.Scanner;

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

      char[] chars = input.toCharArray();
      for (char c : chars) {
        if (!Character.isLetter(c) &&  c != '-' && c != ' ') {
          System.out.println("Введенная строка не является ФИО");
        }else {
          int count = 0;
          int spaceIndex = input.indexOf(' ');
          int spaceLastIndex = input.lastIndexOf(' ');

          if(input.length() != 0)
          {
            count++;
            for(int i = 0; i < input.length(); i++)
            {
              if(input.charAt(i) == ' ')
              {
                count++;
              }
            }
          }
          if(count != 3){
            System.out.println("Введенная строка не является ФИО");
            break;
          }
          String firstName = input.substring(0, spaceIndex);
          String lastName = input.substring(spaceIndex + 1, spaceLastIndex);
          String otherName = input.substring(spaceLastIndex + 1);
          System.out.println("Фамилия: " + firstName);
          System.out.println("Имя: " + lastName);
          System.out.println("Отчество: " + otherName);
        }
        break;
      }
    }
  }

}
