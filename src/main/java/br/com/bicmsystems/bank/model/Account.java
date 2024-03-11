package br.com.bicmsystems.bank.model;

import java.math.BigDecimal;

public class Account {

    private Client client;

    private BigDecimal balance;

    public Account(br.com.bicmsystems.bank.model.Client client, BigDecimal balance) {
        this.client = client;
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public br.com.bicmsystems.bank.model.Client getClient() {
        return client;
    }

    public void duoBalance(BigDecimal value) {
        this.balance = this.balance.subtract(value);
    }
}
