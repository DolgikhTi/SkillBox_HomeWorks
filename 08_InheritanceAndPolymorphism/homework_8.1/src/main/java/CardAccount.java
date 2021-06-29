public class CardAccount extends BankAccount {
    public CardAccount(){
    }

    @Override
    public void take(double amountToTake) {
        super.take(amountToTake * 1.01);
    }
}
