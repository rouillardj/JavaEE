package fr.imie.contact.repositories;

import fr.imie.contact.entities.*;

import javax.ejb.*;
import javax.persistence.*;
import java.util.*;

@Stateless
public class PersonRepository {

  @PersistenceContext
  private EntityManager em;

  public List<Person> findAll() {
    return em.createQuery("select p from Person p", Person.class).getResultList();
  }

  public Person findById(Integer id) {
    return em.find(Person.class, id);
  }

//  public void modifyById(Integer id) {
//    Person person = findById(id);
//    em.save(person);
//  }


  public void deleteById(Integer id) {
    Person person = findById(id);
    em.remove(person);
  }

  public void save(Person person) {
    if (person.getId() == null) {
      em.persist(person);
    } else {
      em.merge(person);
    }
  }

}
