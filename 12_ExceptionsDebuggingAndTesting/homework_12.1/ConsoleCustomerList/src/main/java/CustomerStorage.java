import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    String nameFormat = "Имя: только рус/eng буквы (без пробелов и других символов)";
    final String nameRegEx = "^[а-яА-яa-zA-Z]*$";

    String surNameFormat = "Фамилия: только рус/eng буквы, возможно - через дефис (без пробелов и других символов))";
    final String surNameRegEx = "^[а-яА-яa-zA-Z\\-]*$";

    String phoneNumberFormat = "Телефон: в формате +79991234567 (10-13 цифр)";
    final String phoneRegEx = "^\\+[\\d]{11,14}$";

    String emailFormat = "E-mail: в формате name@domain.com (только eng буквы, дефисы, подчеркивания, точки, и один символ @)";
    final String emailRegEx = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        if (!data.contains(" ")) {
            throw new IllegalArgumentException(
                    "Ошибка! Введен один компонент из четырех, или компоненты не разделены пробелами");
        }

        String[] components = data.split("\\s+");

        if (components.length > 4) {
            throw new IllegalArgumentException("Ошибка! Введено более четырех компонентов");
        }
        if (components.length < 4) {
            throw new IllegalArgumentException("Ошибка! Введено менее четырех компонентов");
        }

        if (!components[0].matches(nameRegEx)) {
            throw new IllegalArgumentException("Ошибка! " + nameFormat);
        }
        if (!components[1].matches(surNameRegEx)) {
            throw new IllegalArgumentException("Ошибка! " + surNameFormat);
        }
        if (!components[2].matches(emailRegEx)) {
            throw new IllegalArgumentException("Ошибка! " + emailFormat);
        }
        if (!components[3].matches(phoneRegEx)) {
            throw new IllegalArgumentException("Ошибка! " + phoneNumberFormat);
        }

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];

        if (storage.containsKey(name)) {
            throw new IllegalArgumentException("Ошибка! В базе уже есть такая запись");
        }

        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {

        try {

        if (!name.contains(" ")) {
            throw new IllegalArgumentException(
                    "Ошибка! Введено только имя, или только фамилия, или они не разделены пробелом");
        }
        if (!storage.containsKey(name)) {
            throw new IllegalArgumentException("Ошибка! В базе нет такой записи для удаления");
        }

        storage.remove(name);

        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
        }
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }

}