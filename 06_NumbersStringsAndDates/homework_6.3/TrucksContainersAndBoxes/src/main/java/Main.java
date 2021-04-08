import java.util.Scanner;

public class Main {
    static final int BOX_IN_CONTAINER = 27;
    static final int CONTAINER_IN_TRUCK = 12;
    static final int BOX_IN_TRUCK = BOX_IN_CONTAINER * CONTAINER_IN_TRUCK;

    static final String EXIT_CODE = "exit";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String box = scanner.nextLine();
            if (box.equals(EXIT_CODE)) {
                return;
            }

            int boxCont = Integer.parseInt(box);

            int containerCont = 0;
            int truckCont = 0;

            int i = 0;
            while (i < boxCont) {
                if (i % BOX_IN_TRUCK == 0) {
                    System.out.println("Грузовик: " + ++truckCont);
                }
                if (i % BOX_IN_CONTAINER == 0) {
                    System.out.println("\tКонтейнер: " + ++containerCont);
                }
                System.out.println("\t\tЯщик: " + ++i);
            }

            System.out.printf("Необходимо:%nгрузовиков - %d шт.%nконтейнеров - %d шт.%n",
                    truckCont, containerCont);
        }
    }
}

