import entities.*;

import java.util.Comparator;
import java.util.List;

import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class Main {
    public static void main(String[] args) {

        Log.debug("Program start");

        @Cleanup
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(registry).buildMetadata();

        try (SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
             Session session = sessionFactory.openSession()
        ) {
            Log.info("TEACHER MAPPING:");
            final int TEACHER_ID = 1;
            teacherMapping(TEACHER_ID, session);

            Log.info("COURSE MAPPING:");
            final int COURSE_ID = 1;
            courseMapping(COURSE_ID, session);

            Log.info("STUDENT MAPPING:");
            final int STUDENT_ID = 1;
            studentMapping(STUDENT_ID, session);

            Log.info("SUBSCRIPTION MAPPING:");
            final int COURSE_ID_2 = 1;
            final int SUBSCRIPTION_NUMBER = 1;
            subscriptionMapping(COURSE_ID_2, SUBSCRIPTION_NUMBER, session);

            Log.info("PURCHASE MAPPING:");
            final int COURSE_ID_3 = 1;
            final int PURCHASE_NUMBER = 0;
            purchaseMapping(COURSE_ID_3, PURCHASE_NUMBER, session);

            Log.info("TOTAL MAPPING:");
            final int COURSE_ID_4 = 10;
            totalMapping(COURSE_ID_3, session);

            Log.info("PURCHASE LIST:");
            List<Purchase> purchases = getPurchases(session);

            Log.info("LINKED PURCHASE LIST:");
            fillLinkedPurchaseList(purchases, session);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.debug("Program completed");
    }

    private static void teacherMapping(int teacherId, Session session) {
        Teacher teacher = session.get(Teacher.class, teacherId);
        Log.teacherMapping(teacherId, teacher);
    }

    private static void courseMapping(int courseId, Session session) {
        Course course = session.get(Course.class, courseId);
        Log.courseMapping(courseId, course);
    }

    private static void studentMapping(int studentId, Session session) {
        Student student = session.get(Student.class, studentId);
        Log.studentMapping(studentId, student);
    }

    private static void subscriptionMapping(int courseId, int subscriptionNumber, Session session) {
        Course course = session.get(Course.class, courseId);
        Subscription.Key key = course.getSubscriptions().get(subscriptionNumber).getSbsKey();
        Subscription subscription = session.get(Subscription.class, key);
        Log.subscriptionMapping(subscriptionNumber, subscription);
    }

    private static void purchaseMapping(int courseId, int purchaseNumber, Session session) {
        Course course = session.get(Course.class, courseId);
        Purchase.Key key = course.getPurchases().get(purchaseNumber).getPKey();
        Purchase purchase = session.get(Purchase.class, key);
        Log.purchaseMapping(purchaseNumber, purchase);
    }

    private static void totalMapping(int courseNumber, Session session) {
        Course course = session.get(Course.class, courseNumber);
        Log.totalMapping(course);

        List<Course> teacherCourses = course.getTeacher().getCourses();
        for (int i = 0; i < teacherCourses.size(); i++) {
            Course teacherCourse = teacherCourses.get(i);
            Log.teacherCourse(i, teacherCourse);

            courseSubscriptions(teacherCourse);
            studentsOnCourse(teacherCourse);
        }
    }

    private static void courseSubscriptions(Course course) {
        List<Subscription> courseSubscriptions = course.getSubscriptions();
        courseSubscriptions.sort(Comparator.comparing(Subscription::getSubscriptionDate));
        for (int i = 0; i < courseSubscriptions.size(); i++) {
            Subscription subscription = courseSubscriptions.get(i);
            Log.courseSubscription(i, subscription);
        }
        System.out.println();
    }

    private static void studentsOnCourse(Course teacherCourse) {
        List<Student> studentsOnCourse = teacherCourse.getStudents();
        for (int i = 0; i < studentsOnCourse.size(); i++) {
            Student student = studentsOnCourse.get(i);

            Log.info(String.format("\t\t%d. Student:\t%s", (i + 1), student.getName()));

            List<Subscription> studentSubscriptions = student.getSubscriptions();
            studentSubscriptions.sort(Comparator.comparing(Subscription::getSubscriptionDate));
            for (int j = 0; j < studentSubscriptions.size(); j++) {
                Subscription subscription = studentSubscriptions.get(j);
                Log.studentOnCourse(j, subscription);
            }
            System.out.println();
        }
    }

    private static List<Purchase> getPurchases(Session session) {
        Query<Purchase> query = session.createQuery("FROM Purchase");
        List<Purchase> purchases = query.list();
        purchases.forEach(p -> Log.info(p.toString()));
        System.out.println();
        return purchases;
    }

    private static void fillLinkedPurchaseList(List<Purchase> purchases, Session session) {
        for (Purchase p : purchases) {
            session.beginTransaction();

            int courseId = p.getPKey().getCourse().getId();
            int studentId = p.getPKey().getStudent().getId();
            LinkedPurchase linkedPurchase = new LinkedPurchase(courseId, studentId);

            session.save(linkedPurchase);
            session.getTransaction().commit();
        }

        Query<LinkedPurchase> query = session.createQuery("FROM LinkedPurchase");
        List<LinkedPurchase> linkedPurchases = query.list();
        linkedPurchases.forEach(l -> Log.info(l.toString()));
    }
}
