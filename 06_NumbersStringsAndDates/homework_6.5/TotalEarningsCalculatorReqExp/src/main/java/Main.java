public class Main {

  public static void main(String[] args) {

  }

  public static int calculateSalarySum(String text){
    //TODO: реализуйте метод
    String text1 = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    int sumDigit = 0;
    for (String word : text.split(" ")) {
      try {
        sumDigit += Integer.parseInt(word);
      } catch (NumberFormatException ignored) {
      }
    }
    System.out.println(sumDigit);
    return sumDigit;
  }

}