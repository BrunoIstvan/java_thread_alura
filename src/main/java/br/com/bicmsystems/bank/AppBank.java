package br.com.bicmsystems.bank;

import br.com.bicmsystems.bank.model.Account;
import br.com.bicmsystems.bank.model.Client;
import br.com.bicmsystems.bank.model.OperationWithdraw;

import java.math.BigDecimal;


public class AppBank {
    public static void main(String[] args) {

        var client = new Client("Bruno");

        var account = new Account(client, new BigDecimal("150"));

        var operationWithdraw = new OperationWithdraw(account, new BigDecimal("150"));

        var firstThread = new Thread(operationWithdraw);
        var secondThread = new Thread(operationWithdraw);

        firstThread.start();
        secondThread.start();

        System.out.println(Thread.currentThread().getName());

        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

        System.out.println("Final Balance: " + account.getBalance());

    }
}