package edu.evacodekitchen.javabasics.bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Account {

    protected String owner;
    protected String id;
    protected List<Transaction> transactions;
    private int balance;

    public Account(String owner, String id) {
        this.owner = owner;
        this.id = id;
        balance = 0;
        transactions = new ArrayList<Transaction>();
    }

    public int getBalance() {
        return balance;
    }

    public void doTransaction(int amount, LocalDate date) {
        if (balance + amount >= 0) {
            balance += amount;
            transactions.add(new Transaction(date, amount));
        } else {
            throw new TooLowBalanceException();
        }
    }

    public List<Transaction> getTransactionsFor(LocalDate date) {
        return transactions.stream().filter(p -> p.getDate().equals(date)).collect(Collectors.toList());
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Account account = (Account) o;
		return balance == account.balance && Objects.equals(owner, account.owner) && Objects.equals(id, account.id) && Objects.equals(transactions, account.transactions);
	}

	@Override
	public int hashCode() {
		return Objects.hash(owner, id, transactions, balance);
	}
}
