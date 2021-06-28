public class PhysicalPerson extends Client {

    public PhysicalPerson() {

    }
    @Override
    public void put(double amountToPut) {
        if (getAmount() > amountToPut){
            System.out.println("ОШИБКА!");
        }else {
            setAmount(getAmount() + amountToPut);
            System.out.println("На счёт поступила сумма " + amountToPut);
        }
    }

    @Override
    public void take(double amountToTake) {
        if (getAmount() < amountToTake){
            System.out.println("Остатка на счёте " + getAmount() + " недостаточно для списания " + amountToTake);
        }else {
            setAmount(getAmount() - amountToTake);
            System.out.println("Со счёта списана сумма " + amountToTake);
        }
    }
}
