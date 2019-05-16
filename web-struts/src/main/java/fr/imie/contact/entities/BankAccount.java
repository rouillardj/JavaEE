package fr.imie.contact.entities;

import javax.persistence.*;
import java.math.*;

@Entity
public class BankAccount {

    @Id @GeneratedValue
    private Integer id;

    private BigDecimal balance;

    @ManyToOne @JoinColumn(nullable = false)
    private Person owner;

    // region // constructors getters setters

    public BankAccount() {
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // endregion

}