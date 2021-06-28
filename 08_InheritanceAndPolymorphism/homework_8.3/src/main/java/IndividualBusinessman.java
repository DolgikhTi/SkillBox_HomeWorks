public class IndividualBusinessman extends Client {

    public IndividualBusinessman (){

    }
    @Override
    public void put(double amountToPut) {
        System.out.println("На счёт поступила сумма: " + amountToPut);
        if (getAmount() > amountToPut) {
            System.out.println("ОШИБКА!");
        } else if (amountToPut < 1000) {
            double bankFeeLess1000 = amountToPut * 0.01;
            System.out.println("Комиссия банка за пополнение счета\n" +
                    "      на сумму менее 1000.0 равна 1%: " + bankFeeLess1000);
            setAmount(getAmount() + amountToPut - bankFeeLess1000);
        } else {
            double bankFeeMore1000 = amountToPut * 0.005;
            System.out.println("Комиссия банка за пополнение счета\n" +
                    "      на сумму более 1000.0 равна 0.5%: " + bankFeeMore1000);
            setAmount(getAmount() + amountToPut - bankFeeMore1000);
        }

    }

    @Override
    public void take(double amountToTake) {
        if (getAmount() < amountToTake){
            System.out.println("Остатка на счёте " + getAmount() + " недостаточно для списания " + amountToTake);
        }else {
            setAmount(getAmount() - amountToTake);
            System.out.println("Со счёта списна сумма " + amountToTake);
        }
    }
}
