import java.util.Scanner;

public class Main {

    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList

        boolean firstLap = true;

        for(;;) {

            System.out.println(firstLap ? "Введите команду:" :
                    "\nВведите команду, или END для завершения:");
            firstLap = false;

            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextLine()){
                case "LIST":
                    todoList.add(0, scanner.nextLine());
                    System.out.println();
                    continue;

                case "ADD":
                    todoList.add(scanner.nextLine());
                    System.out.println("Добавлено дело " + scanner.nextLine());
                    continue;

                case "EDIT":
                    System.out.println("Заменить дело в списке:");
                    todoList.edit(scanner.nextLine(), 0);
                    System.out.println("Дело " + scanner.nextLine() + " заменено на " + scanner.nextLine());
                    continue;

                case "DELETE":
                    System.out.println("Удалить дело из списка: ");
                    todoList.delete(scanner.nextInt() - 1);
                    System.out.println("Дело " + scanner.nextLine() + " удалено" );
                    continue;

                case "END":
                    System.out.println("Работа завершена");
                    break;
            }
        }
    }
}
