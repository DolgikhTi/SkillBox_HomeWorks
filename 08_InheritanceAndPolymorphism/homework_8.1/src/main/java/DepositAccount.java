import java.time.LocalDate;

public class DepositAccount extends BankAccount {

    private static LocalDate lastIncome;

    public DepositAccount(){

    }

    @Override
    public void put(double amountToPut) {
        if (getAmount() > amountToPut){
            System.out.println("Ошибка!");
        }else {
            setAmount(getAmount() + amountToPut);
            lastIncome = LocalDate.now().plusMonths(31);
            System.out.println("Пополнение счёта на сумму: " + amountToPut);
        }
    }

}
