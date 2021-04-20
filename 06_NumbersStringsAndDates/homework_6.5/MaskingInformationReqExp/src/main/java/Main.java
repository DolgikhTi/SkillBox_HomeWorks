public class Main {

    private static final String REGEX_SPLIT_MASK_INFO = "<[^>]+>";

    public static void main(String[] args) {

    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
        return text.replaceAll(REGEX_SPLIT_MASK_INFO, "***");
    }

}