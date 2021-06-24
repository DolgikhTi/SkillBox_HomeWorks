import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PhoneBook {

    TreeMap<String, String> phoneBook = new TreeMap<>();

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if (phone.matches("^[0-9]+$") && name.matches("^[a-zA-Zа-яА-Я]+$")){
        phoneBook.put(phone, name);
        }
    }

    public String getNameByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        StringBuilder nameWithPhones = new StringBuilder();

        phoneBook.entrySet()
                .stream()
                .filter(pair -> pair.getKey().equals(phone))
                .forEach(pair -> {
                    if (nameWithPhones.length() == 0) {
                        nameWithPhones.append(pair.getValue()).append(" - ");
                    }
                    nameWithPhones.append(pair.getKey()).append(" ");
                });

        return nameWithPhones.toString().trim();
    }

    public Set<String> getPhonesByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        StringBuilder nameWithPhones = new StringBuilder();
        TreeSet<String> phoneSet = new TreeSet<>();

        phoneBook.entrySet()
                .stream()
                .filter(pair -> pair.getValue().equals(name))
                .forEach(pair -> {
                    if (nameWithPhones.length() == 0) {
                        nameWithPhones.append(name).append(" - ");
                    }
                    nameWithPhones.append(pair.getKey()).append(" ");
                });

        if (nameWithPhones.length() > 0) {
            phoneSet.add(nameWithPhones.toString().trim());
        }

        return phoneSet;
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        TreeSet<String> phoneSet = new TreeSet<>();

        phoneBook.forEach((key, value) -> {
            StringBuilder builder = new StringBuilder();
            builder.append(value).append(" - ");
            phoneBook.entrySet()
                    .stream()
                    .filter(pair -> pair.getValue().equals(value))
                    .forEach(pair -> builder.append(pair.getKey()).append(" "));
            phoneSet.add(builder.toString().trim());
        });

        return phoneSet;
    }

}