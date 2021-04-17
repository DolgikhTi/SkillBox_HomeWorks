import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
    }

    public static String collectBirthdays(int year, int month, int day) {

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue

        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd.MM.yyyy - E", Locale.ENGLISH);
        int x = 0;
        String text = "";
        StringBuilder st = new StringBuilder();

        while (birthday.isBefore(today) || birthday.equals(today))
        {
            text = x + " - " + birthday.format(formatDate);
            st.append(text);
            st.append("\n");

            System.out.println(text);
            x++;
            birthday = birthday.plusYears(1);
        }
        return st.toString();
    }
}
