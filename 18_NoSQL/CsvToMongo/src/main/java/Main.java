import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import properties.Props;
import storage.MongoStorage;
import util.Logger;
import util.Parser;

import java.util.List;

public class Main {

    private static final Props PROPS = Props.INSTANCE;

    public static void main(String[] args) {

        try (MongoStorage storage = new MongoStorage()) {

            MongoDatabase db = storage.getDatabase(PROPS.getDbName());
            db.getCollection(PROPS.getCollectionName()).drop();
            MongoCollection<Document> collection =
                    db.getCollection(PROPS.getCollectionName());

            List<Document> students = Parser.parse(PROPS.getCsvFile());
            collection.insertMany(students);

            Logger.logStudentsCount(collection);
            Logger.logStudentsOver40(collection);
            Logger.logOneOfYoungestStudents(collection);
            Logger.logOneOfOldestStudentsCourseList(collection);
        }
    }
}
