import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Loader {

    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private static SimpleDateFormat visitDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    private static HashMap<Integer, WorkTime> voteStationWorkTimes = new HashMap<>();
    private static HashMap<Voter, Integer> voterCounts = new HashMap<>();

    public static void main(String[] args) throws Exception {
        String fileName = "res/data-1M.xml";

        long start = System.currentTimeMillis();
        System.out.println("Время начала работы: " + LocalTime.now().toString());


        try (StaxStreamProcessor processor = new StaxStreamProcessor(Files.newInputStream(Paths.get(fileName)))) {
            processor.startElement();
        }

        InsertDuplicatesVoters insertDuplicatesVoters = new InsertDuplicatesVoters();
        insertDuplicatesVoters.addDuplicates();
        System.out.println("Время окончания работы: " + LocalTime.now().toString());
        long end = System.currentTimeMillis();
        System.out.println("Parsing Duration: " + getMinutes(start, end) + " minutes");

        DBConnection.printVoterCounts();
    }

    public static double getMinutes(long start, long end){
        return (double) (end - start) / 1000 / 60;
    }
}