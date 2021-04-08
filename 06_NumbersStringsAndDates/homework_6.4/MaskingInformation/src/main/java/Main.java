import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(searchAndReplaceDiamonds("Номер кредитной карты <4008 1234 5678> 8912",
                "***"));
        String str = scanner.nextLine();
        String text = "< >";
        String hiddenText = text;
        while (hiddenText.contains("<") && hiddenText.contains(">"))
        {
            hiddenText = searchAndReplaceDiamonds("Номер кредитной карты <4008 1234 5678> 8912", "***");
            System.out.println(hiddenText);
        }
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
        int i = text.indexOf('<');
        int i1 = text.indexOf('>');
        if (i > -1 & i1 > -1)
        {
            text = text.substring(0, i) + placeholder + text.substring(i1 + 1);
        }
        return text;
    }
}
