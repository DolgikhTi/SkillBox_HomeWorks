import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int container = 1;
        int truck = 1;
        int boxInCont = 27;
        int contInTruck = 12;
        Scanner scanner = new Scanner(System.in);
        int box = scanner.nextInt();
        if (box > 0){
            System.out.println("Грузовик: " + truck);
            System.out.println("\tКонтейнер: " + container);
            for (int i = 1; i <= box; i++) {
                System.out.println("\t\tЯщик: " + i);
                if (i % (contInTruck * boxInCont) == 0) {
                    truck += 1;
                    System.out.println("Грузовик: " + truck);
                }
                if (i % boxInCont == 0) {
                    container += 1;
                    System.out.println("\tКонтейнер: " + container);
                }
            }
            System.out.println("Необходимо:\nгрузовиков - " + truck + " шт." + "\nконтейнеров - " + container + " шт.");

        }
        else {
            System.out.println(" У Вас отсутствуют ящики");
        }
    }
}
