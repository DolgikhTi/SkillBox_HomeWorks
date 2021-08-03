import java.io.FileReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import au.com.bytecode.opencsv.CSVReader;

public class Movements {

    List<Movements> listMovements = new ArrayList<>();
    String description;
    String coming;
    String expenditure;
    Double incomeSum = 0.0;
    Double expenseSum = 0.0;

    public Movements(String pathMovementsCsv) {
        try {
            List<String[]> list = readFile(pathMovementsCsv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String[]> readFile(String reader) throws Exception {

        List<String[]> list = new ArrayList<>();

        boolean firstLine = true;

        try (CSVReader csvReader = new CSVReader(new FileReader(reader))) {

            NumberFormat numberFormat = NumberFormat.getInstance();
            String[] line;
            System.out.println("Суммы расходов по организациям: ");

            while ((line = csvReader.readNext()) != null) {
                if (firstLine) {
                    firstLine = false;
                } else {
                    description = line[5];
                    coming = line[6];
                    expenditure = line[7];
                    System.out.println(description.trim() + " " + expenditure + " руб.");
                    incomeSum += numberFormat.parse(coming).doubleValue();
                    expenseSum += numberFormat.parse(expenditure).doubleValue();
                }
            }
        }
        return list;
    }

    public double getExpenseSum() {
        return expenseSum;
    }

    public double getIncomeSum() {
        return incomeSum;
    }

    @Override
    public String toString() {

        return listMovements.toString() + System.lineSeparator();

    }
}
