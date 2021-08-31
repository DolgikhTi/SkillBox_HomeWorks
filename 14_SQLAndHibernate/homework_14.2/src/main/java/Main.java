import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        System.out.println("Введите название курса");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int i = 1;
        for (;;) {
            if (session.get(Course.class, i) == null) {
                System.out.println("Курса не существует");
                break;
            } else {
                Course course = session.get(Course.class, i);
                if (course.getName().equalsIgnoreCase(input)) {
                    System.out.println(course.getName() + " " + course.getStudentCount());
                    break;
                } else {
                    i++;
                }
            }
        }

        sessionFactory.close();
    }
}
