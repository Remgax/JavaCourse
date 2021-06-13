package edu.evacodekitchen.javabasics.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bank {

    protected List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Account> getPremiumAccounts() {
        return accounts.stream().filter(p -> p.getBalance() > 12000).collect(Collectors.toList());
    }

}
