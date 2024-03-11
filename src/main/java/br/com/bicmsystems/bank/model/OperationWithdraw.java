package br.com.bicmsystems.bank.model;

import java.math.BigDecimal;

public class OperationWithdraw implements Runnable {

    private br.com.bicmsystems.bank.model.Account account;

    private BigDecimal value;

    public OperationWithdraw(br.com.bicmsystems.bank.model.Account account, BigDecimal value) {
        this.account = account;
        this.value = value;
    }

    private synchronized void execute() {

        System.out.println("Initializing withdraw operation - Client: " + account.getClient().getName() + " - Value: " + value);
        var currentBalance = account.getBalance();

        if (currentBalance.compareTo(value) >= 0) {
            System.out.println("Debiting account amount - Value: " + value + " - Client: " + account.getClient().getName());
            account.duoBalance(value);
            System.out.println("Current Balance: " + account.getBalance() + " - Client: " + account.getClient().getName());
        }

        System.out.println("Finishing withdraw operation - Client: " + account.getClient().getName());
    }

    @Override
    public void run() {
        execute();
        System.out.println(Thread.currentThread().getName());
    }
}
