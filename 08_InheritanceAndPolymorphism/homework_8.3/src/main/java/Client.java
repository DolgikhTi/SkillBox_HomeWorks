public abstract class Client {

    private double amount;

    public double getAmount() {
        return amount;
    }

    public abstract void put(double amountToPut);

    public abstract void take(double amountToTake);

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
