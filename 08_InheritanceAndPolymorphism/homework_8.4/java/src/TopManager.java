public class TopManager implements Employee {

    Company company = new Company();

    public static int FIX_SALARY = 15000000;

    public int getMonthSalary() {
        return FIX_SALARY + company.getIncome() > 10000000 ? (int) (FIX_SALARY * 1.5) : 0;
    }

}
