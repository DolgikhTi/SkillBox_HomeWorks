public class Main {

  public static void main(String[] args) {
  }

  public static String splitTextIntoWords(String text) {
    //TODO реализуйте метод

    String englishText = "London is the capital of the United Kingdom, " +
            "one of the largest and one of the world’s most enjoyable cities. " +
            "It offers the tourists an astonishing variety of scene. " +
            "In this historic city the modern rubs shoulders with the old, the present is ever conscious of the past, " +
            "the great and the small live side by side in mutual tolerance and respect. " +
            "London is more than 20 centuries old. Its buildings express all the different areas of its history, " +
            "for London manages in a unique way to reflect its past and at the same time to fulfil the functions of a modern city.";

    String[] sentences = englishText.split("\\W+");
    for (int i = 0; i < sentences.length; i++)
    {
      System.out.println(sentences[i]);
    }
    return text.replaceAll("[\\d\\s\\p{Punct}]+", "\n").trim();
  }

}