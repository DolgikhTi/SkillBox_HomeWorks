public class CardAccount extends BankAccount {
    public CardAccount(){
    }

    @Override
    public void take(double amountToTake) {
        double bank = amountToTake * 0.01;
        if (getAmount() < amountToTake + bank){
            System.out.println("Остатка на счёте " + getAmount() + "недостаточно для списания" + amountToTake);
            System.out.println("  с учётом комисии в 1%: " + bank);
        }else {
            System.out.println("Cо счёта списана сумма: " + amountToTake);
            System.out.println("Коммисия банка: " + bank);
            setAmount(getAmount() - (amountToTake + bank));
        }
    }
}
