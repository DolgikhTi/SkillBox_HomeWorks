package util;

import au.com.bytecode.opencsv.CSVReader;
import org.bson.Document;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Parser {

    public static List<Document> parse(String fileName) {

        List<Document> studentList = new ArrayList<>();

        try (FileReader fr = new FileReader(fileName);
             CSVReader reader = new CSVReader(fr, ',', '"', 1)) {

            String[] nextStudent;
            while ((nextStudent = reader.readNext()) != null) {

                Map<String, Object> student = new LinkedHashMap<>();
                student.put("name", nextStudent[0]);
                student.put("age", Integer.parseInt(nextStudent[1]));
                student.put("courses", Arrays.asList(nextStudent[2].split(",\\s*")));

                studentList.add(new Document(student));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
