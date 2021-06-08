import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<String> todoList = new ArrayList<>();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList

        boolean firstLap = true;

        for(;;) {

            System.out.println(firstLap ? "Введите команду (для подсказки введите HELP):" :
                    "\nВведите команду, или END для завершения:");
            firstLap = false;

            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextLine()){
                case "LIST":
                    System.out.println("Ваш список дел: " + todoList);
                    continue;

                case "ADD":
                    System.out.println("Добавить дело в список: ");
                    todoList.add(scanner.nextLine());
                    System.out.println("Дело добавлено! " + "номер в списке: " + todoList.size());
                    continue;

                case "EDIT":
                    System.out.println("Заменить дело в списке:");
                    todoList.set(0, scanner.nextLine());
                    System.out.println("Дело " + todoList.size() + " заменено на " + todoList.size());
                    continue;

                case "DELETE":
                    System.out.println("Удалить дело из списка: ");
                    todoList.remove(scanner.nextInt() - 1);
                    System.out.println("Дело удалено!" + todoList.size());
                    continue;

                default:
                    System.out.println("Выберем действие: ");
                    break;
            }
        }
    }

    private static int id(String input) {
        int id;

        if (input.length() == 0) {
            id = todoList.size();
        }
        else {
            id = Integer.parseInt(input);
        }
        return id;
    }

    private static boolean idOutOfListSize(int id) {
        boolean idOutOfListSize = false;
        if (id > todoList.size()) {
            idOutOfListSize = true;
        }
        return idOutOfListSize;
    }

    private static void add(int id, String value) {
        if (idOutOfListSize(id)) {
            System.out.println("Введен слишком большой номер: " + id +"\nЗадача будет добавлена в конец списка\n");
            id = todoList.size();
        }
        todoList.add(id, value);
        System.out.println("Задача " + id + " добавлена");
        list();
    }

    private static void edit(int id, String value) {
        if (idOutOfListSize(id)) {
            System.out.println(todoList.size() == 0 ?
                    "\"Список пуст! Добавьте свою первую задачу командой 'ADD Описание задачи'\"" :
                    "\nОШИБКА!\nВведите номер задачи  от 0 до " + (todoList.size() - 1));
        }
        else {
            todoList.remove(id);
            todoList.add(id, value);
            System.out.println("Задача " + id + " изменена");
            list();
        }
    }

    private static void del(int id) {
        if (idOutOfListSize(id)) {
            System.out.println(todoList.size() == 0 ?
                    "\"Список пуст! Добавьте свою первую задачу командой 'ADD Описание задачи'\"" :
                    "\nОШИБКА!\nВведите номер задачи  от 0 до " + (todoList.size() - 1));
        }
        else {
            todoList.remove(id);
            System.out.println("Задача " + id + " удалена");
            list();
        }
    }

    private static void list() {
        TodoList todoList1 = new TodoList();
        System.out.println(todoList1);
    }

    private static void help() {
        System.out.println("\nКОМАНДЫ:\n" +
                "Добавить зазачу:   ADD Номер Описание задачи (номер указывать не обязательно) \n" +
                "Изменить задачу:   EDIT Номер задачи Обновленное описание задачи \n" +
                "Удалить задачу:    DEL Номер задачи\n" +
                "Список задач:      LIST\n" +
                "Завершение работы: END bkb EXIT"
        );
    }
}
