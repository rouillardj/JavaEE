package fr.imie.contact.entities;

import javax.persistence.*;
import java.time.*;
import java.util.*;

@Entity
public class Person {

  @Id @GeneratedValue
  private Integer id;

  private String firstName;

  private String lastName;

  private String email;

  private LocalDate birthDate;

  @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
  private List<BankAccount> accounts = new ArrayList<BankAccount>();

  // region // constructors getters setters

  public Person() {
  }

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public List<BankAccount> getAccounts() {
    return accounts;
  }

  public void addAccount(BankAccount account) {
    this.accounts.add(account);
  }

  // endregion

}
