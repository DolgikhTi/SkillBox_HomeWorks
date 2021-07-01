import java.time.LocalDate;
import java.time.Period;

public class Main {

  public static void main(String[] args) {

  }

  private static String getPeriodFromBirthday(LocalDate birthday) {
    LocalDate now = LocalDate.now();
    Period p = Period.between(birthday, now);
    System.out.println(p.getYears() + " years, " + p.getMonths() + " months, " + p.getDays() + " days");

    return "";
  }

}
