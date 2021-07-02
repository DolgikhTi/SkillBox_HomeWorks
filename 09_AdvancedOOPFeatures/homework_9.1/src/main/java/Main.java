import java.util.Collections;
import java.util.List;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        System.out.println(staff);
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        //TODO Метод должен отсортировать сотрудников по заработной плате и алфавиту.

        Collections.sort(staff, (o1, o2) -> {

            int salaryCompare = o1.getSalary().compareTo(o2.getSalary());
                if (salaryCompare == 0){
                    return o1.getName().compareTo(o2.getName());
                }
                return salaryCompare;
        });
    }

}