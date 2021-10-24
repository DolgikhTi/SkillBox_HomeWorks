package util;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.List;
import java.util.Objects;

import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Sorts.ascending;
import static com.mongodb.client.model.Sorts.descending;

public class Logger {

    public static void logStudentsCount(MongoCollection<Document> collection) {
        System.out.println("Students count: " + collection.countDocuments());
    }

    public static void logStudentsOver40(MongoCollection<Document> collection) {
        System.out.println("Number of students over 40: " +
                collection.countDocuments(gt("age", 40)));

        FindIterable<Document> studentsOver40 = collection
                .find(gt("age", 40))
                .sort(ascending("age"));

        for (Document student : studentsOver40) {
            System.out.printf("- %s, age %s%n",
                    student.getString("name"), student.get("age"));
        }
    }

    public static void logOneOfYoungestStudents(MongoCollection<Document> collection) {
        Document student = Objects.requireNonNull(collection.find()
                .sort(ascending("age")).first());

        System.out.printf("Youngest student: %s, age %s%n",
                student.getString("name"), student.get("age"));
    }

    public static void logOneOfOldestStudentsCourseList(MongoCollection<Document> collection) {
        Document student = Objects.requireNonNull(collection.find()
                .sort(descending("age")).first());

        System.out.printf("Courses list of one of the oldest students, %s, age %s:%n",
                student.getString("name"), student.get("age"));

        List<String> courses = (List<String>) student.get("courses");
        courses.forEach(course -> System.out.println("- " + course));
    }
}
