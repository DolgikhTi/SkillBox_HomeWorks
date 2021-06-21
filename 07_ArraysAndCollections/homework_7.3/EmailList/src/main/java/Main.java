import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static EmailList email = new EmailList();
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    
    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            //TODO: write code here
            input = input.replaceAll("\\s\\s", " ").trim();
            Pattern pattern = Pattern.compile("(?i)(^ADD|^LIST|^END)");
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String command = matcher.group().toUpperCase();

                if (!command.equals("END")) {

                    if (command.equals("ADD")) {
                        email.add(input);
                    } else {
                        System.out.println(WRONG_EMAIL_ANSWER);
                    }

                    if (command.equals("LIST")) {
                        email.getSortedEmails();
                    } else {
                        return;
                    }
                }

            }
        }
    }

}
