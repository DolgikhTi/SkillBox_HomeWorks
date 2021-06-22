import java.util.TreeSet;

public class EmailList {

    TreeSet<String> emails = new TreeSet<>();
    private static final String REGEX_MAIL = "\\w+@\\w+\\.(ru|com)";

    public void add(String email) {
        // TODO: валидный формат email добавляется

        if (email.matches(REGEX_MAIL)){
            emails.add(email.toLowerCase());
        }
    }

    public TreeSet<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке
        return emails;
    }

}
