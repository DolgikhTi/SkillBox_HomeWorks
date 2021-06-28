public class BankAccount {

  private double amount;

  public double getAmount() {
    return amount;
  }

  public void put(double amountToPut) {
    if (getAmount() > amountToPut){
      System.out.println("Ошибка!");
    }else {
      amount = getAmount() + amountToPut;
    }
  }

  public void take(double amountToTake) {
    if (getAmount() < amountToTake){
      System.out.println("недостаточно средств");
    }else {
      amount = getAmount() - amountToTake;
    }
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public boolean send(BankAccount receiver, double amount) {
    if (this.amount >= amount){
      this.amount -= amount;
      receiver.amount += amount;
      return true;
    }
    return false;
  }
}
