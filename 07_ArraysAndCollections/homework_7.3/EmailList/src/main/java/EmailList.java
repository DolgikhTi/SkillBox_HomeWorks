import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {

    TreeSet<String> emails = new TreeSet<>();

    public void add(String email) {
        // TODO: валидный формат email добавляется
        Pattern pattern = Pattern.compile("\\w+@\\w+\\.(ru|com)");
        Matcher matcher = pattern.matcher(email.toLowerCase());
        if (!matcher.find()){
            emails.clear();
        } else {
            emails.add(matcher.group());
        }
    }

    public TreeSet<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке
        return emails;
    }

}
