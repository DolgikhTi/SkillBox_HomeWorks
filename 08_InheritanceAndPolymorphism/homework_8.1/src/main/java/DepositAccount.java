import java.time.LocalDate;

public class DepositAccount extends BankAccount {

    private static LocalDate lastIncome;

    public DepositAccount(){

    }

    @Override
    public void put(double amountToPut) {
        super.put(amountToPut);
        lastIncome = LocalDate.now().plusMonths(31);
        System.out.println("Пополнение счёта на сумму: " + amountToPut);
    }

}
