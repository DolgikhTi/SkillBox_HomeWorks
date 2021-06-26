import java.util.*;

public class CoolNumbers {

    private static List<String> numbersBase = new ArrayList<>();

    public static List<String> generateCoolNumbers() {

        String[] stateNumbers = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        String digits;
        int regions;

        for (regions = 1; regions <= 199; regions++){
            for (String str : stateNumbers){
                for (int i = 1; i <= 999; i++){
                    if (i < 10){
                        digits = "00" + i;
                    }else if (i < 100){
                        digits = "0" + i;
                    }else {
                        digits = Integer.toString(i);
                    }
                    numbersBase.add(str + digits + str + str + (regions < 10 ? "0" + regions : regions));
                }
            }
        }

        return numbersBase;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {

        long ln = System.nanoTime();
            if (list.contains(number)) {
                long duration = System.nanoTime() - ln;
                System.out.println("Поиск перебором: Номер " + number + " найден, поиск занял " + duration + " нс ");
                return true;
            }
        return false;

    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {

        long start = System.nanoTime();
        if (sortedList.contains(number)){
        Collections.binarySearch(numbersBase, number);
        long duration = System.nanoTime() - start;
        System.out.println("Бинарный поиск: Номер " + number + " найден, поиск занял " + duration + " нс ");
        return true;
        }

        return false;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {

        long start = System.nanoTime();
            if (hashSet.contains(number)) {
                long duration = System.nanoTime() - start;
                System.out.println("Поиск в HashSet: номер " + number + " найден, поиск занял " + duration + " нс ");
                return true;
            }
        return false;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {

        long start = System.nanoTime();
        if (treeSet.contains(number)) {
            long duration = System.nanoTime() - start;
            System.out.println("Поиск в TreeSet: номер " + number + " найден, поиск занял " + duration + " нс ");
            return true;
        }
        return false;
    }

}
