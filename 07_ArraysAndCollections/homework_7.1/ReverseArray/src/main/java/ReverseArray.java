public class ReverseArray {

    //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.
    public static String[] reverse (String[] strings){
        for (int i = 0; i < strings.length / 2; i++) {
            String string1 = strings[i];
            strings[i] = strings[strings.length - i - 1];
            strings[strings.length - i - 1] = string1;
        }
        return strings;
    }
}
