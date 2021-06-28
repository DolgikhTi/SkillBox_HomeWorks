public class LegalPerson extends Client {
    public LegalPerson() {

    }
    @Override
    public void put(double amountToPut) {
        if (getAmount() > amountToPut){
            System.out.println("Ошибка!");
        }else {
        setAmount(getAmount() + amountToPut);
        System.out.println("На счёт поступила сумма " + amountToPut);
        }
    }

    @Override
    public void take(double amountToTake) {
        double bankFee = amountToTake * 0.01;
        if (getAmount() < amountToTake + bankFee){
            System.out.println("Остатка на счёте " + getAmount() + " недостаточно для списания " + amountToTake);
            System.out.println("   с учётом комиссии банка в 1% " + bankFee);
        }else {
            setAmount(getAmount() - amountToTake - bankFee);
            System.out.println("Со счёта списана сумма: " + amountToTake);
            System.out.println("Комиссия за вывод средст: " + bankFee);
        }
    }
}
