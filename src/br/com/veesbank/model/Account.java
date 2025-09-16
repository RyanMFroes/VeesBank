package br.com.veesbank.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String number;                   // Número da conta
    private BigDecimal balance;              // Saldo
    private Custumer custumer;               // Dono da conta
    private List<Transaction> transactions;  // Histórico de transações

    public Account(String number, Custumer customer) {
        this.number = number;
        this.custumer = customer;
        this.balance = BigDecimal.ZERO;
        this.transactions = new ArrayList<>();
    }

    // Getters e Setters
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }

    public Custumer getCustomer() { return custumer; }
    public void setCustomer(Custumer customer) { this.custumer = customer; }

    public List<Transaction> getTransactions() { return transactions; }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public String toString() {
        return "Conta{número='" + number + "', saldo=" + balance + ", cliente=" + custumer.getName() + "}";
    }
}
