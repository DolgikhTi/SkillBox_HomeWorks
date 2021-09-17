package bank;

import utils.Log;

public class Account {

    private long money;
    private String accNumber;
    private final Bank bank;
    private boolean isBlocked;

    Account(Bank bank, String number, long money) {
        this.money = money;
        this.accNumber = number;
        this.bank = bank;
        this.isBlocked = false;
        Log.created(this);
    }

    synchronized long getMoney() {
        return money;
    }

    synchronized String getAccNumber() {
        return accNumber;
    }

    synchronized boolean isBlocked() {
        return isBlocked;
    }

    synchronized void block() {
        isBlocked = true;
        Log.accountBlocked(this);
    }

    synchronized void unBlock() {
        isBlocked = false;
        Log.accountUnBlocked(this);
    }

    void callPolice() {
        // Любой код для звонка в полицию по поводу мошенничества с переводом
        Log.callPolice(this);
        Log.unBlockedAccountsCount(this.bank);
    }

    synchronized void writeOff(long amount) {
        money -= amount;
    }

    synchronized void writeOn(long amount) {
        money += amount;
    }

    @Override
    public String toString() {
        return String.format("bank.Account %4s\t%8d rub\t%s",
                accNumber, money, (isBlocked ? "Blocked" : "Not blocked"));
    }
}
