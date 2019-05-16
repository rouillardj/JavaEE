package fr.imie.contact.entities;

import javax.persistence.*;
import java.time.*;
import java.util.ArrayList;
import java.util.*;

@Entity
public class Person {

    @Id @GeneratedValue
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private Date birthDate;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    private List<BankAccount> accounts = new ArrayList<BankAccount>();

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void addAccounts(BankAccount account) {
        this.accounts.add(account);
    }
}