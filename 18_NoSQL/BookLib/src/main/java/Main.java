import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);

        MongoDatabase database = mongoClient.getDatabase("local");

        MongoCollection<Document> books = database.getCollection("");

        Document infoBook1 = new Document()
                .append("Название", "Преступление и наказание")
                .append("Имя автора", "Достоевский Ф.М")
                .append("Год создания", "1866 г.");

        books.insertOne(infoBook1);
        books.find().forEach((Consumer<Document>) document -> {
            System.out.println("Превая книга:\n" + document);
        });

        Document infoBook2 = new Document()
                .append("Название", "Идиот")
                .append("Имя автора", "Достовеский Ф.М")
                .append("Год создания", "1868 г.");

        books.insertOne(infoBook2);
        books.find().forEach((Consumer<Document>) document -> {
            System.out.println("Вторая книга:\n" + document);
        });

        Document infoBook3 = new Document()
                .append("Название", " Над кукушкиным гнездом")
                .append("Имя автора", "Кен Кизи")
                .append("Год создания", "1959 г.");

        books.insertOne(infoBook3);
        books.find().forEach((Consumer<Document>) document -> {
            System.out.println("Третья книга:\n" + document);
        });

        Document infoBook4 = new Document()
                .append("Название", "Над пропостью во ржи")
                .append("Имя автора", "Сэлинджер Дж.Д.")
                .append("Год создания", "1951 г.");

        books.insertOne(infoBook4);
        books.find().forEach((Consumer<Document>) document -> {
            System.out.println("Четвёртая книга:\n" + document);
        });

        Document infoBook5 = new Document()
                .append("Название", "Игра престолов")
                .append("Имя автора", "Джордж Р. Р. Мартин")
                .append("Год создания", "1996 г.");

        books.insertOne(infoBook5);
        books.find().forEach((Consumer<Document>) document -> {
            System.out.println("Пятая книга:\n" + document);
        });
    }
}
