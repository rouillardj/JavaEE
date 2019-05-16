package fr.imie.contact.repositories;

import fr.imie.contact.entities.*;

import java.util.*;

public class BankAccountRepositoryMock extends BankAccountRepository {

    private List<BankAccount> bankAccounts = new ArrayList();

    public BankAccountRepositoryMock() {
    }

    public List<BankAccount> findAll() {
        return bankAccounts;
    }

    public void save(BankAccount entity) {
        bankAccounts.add(entity);
    }

}