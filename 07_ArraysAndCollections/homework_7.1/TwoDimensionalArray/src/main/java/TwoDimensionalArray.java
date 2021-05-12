public class TwoDimensionalArray {
    public static char symbol = 'X';
    public static char symbol1 = ' ';

    public static char[][] getTwoDimensionalArray(int size) {

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]

        char[][] text = new char[size][size];
        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < text.length; j++) {
                if (i == j || i + j == (size - 1)) {
                    text[i][j] = symbol;
                } else {
                    text[i][j] = symbol1;
                }
            }
        }
        return text;
    }
}
