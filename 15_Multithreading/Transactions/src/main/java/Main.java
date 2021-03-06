import bank.Bank;
import utils.Log;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Log.timerStart();

        AtomicInteger transfersCount = new AtomicInteger();

        Bank bank = new Bank("New Bank");

        int accountsCount = 10;
        createRandomAccounts(bank, accountsCount);

        BigInteger startBankBalance = bank.getSumAllAccounts();

        while (bank.getUnblockedAccountsCount() >= 2) {
            randomTransfer(bank);
            transfersCount.incrementAndGet();
            Log.counters(transfersCount, bank);
        }

        Log.info("Difference with start bank balance: " +
                bank.getSumAllAccounts().subtract(startBankBalance));
        Log.counters(transfersCount, bank);
        Log.timerFinish(System.currentTimeMillis() - startTime);
    }

    private static void createRandomAccounts(Bank bank, int count) {
        int maxBalance = 2_000_000;
        for (int i = 0; i < count; i++) {
            long money = RANDOM.nextInt(maxBalance);
            bank.createAccount(money);
        }
    }

    private static void randomTransfer(Bank bank) {
        String fromAccountNum = bank.getRandomAccountNum();
        String toAccountNum = bank.getRandomAccountNum();
        long amount = (long) (bank.getBalance(fromAccountNum) * RANDOM.nextDouble());

        bank.isFraud(fromAccountNum, toAccountNum, amount);
    }
}
