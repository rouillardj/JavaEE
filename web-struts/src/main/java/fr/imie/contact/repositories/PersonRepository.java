package fr.imie.contact.repositories;

import fr.imie.contact.entities.*;

import javax.ejb.*;
import javax.persistence.*;
import java.util.*;

@Stateless
public class PersonRepository {

    @PersistenceContext
    private EntityManager em;

    public void deleteById(Integer id) {
        em.remove(em.getReference(Person.class, id));
    }

    public List<Person> findAll() {
        return em.createQuery("select p from Person p", Person.class).getResultList();
    }

    public Person findById(int id) {
        return em.find(Person.class, id);
    }

    public void save(Person person) {

        if(person.getId() == null) {
            em.persist(person);
        } else {
            em.merge(person);
        }
    }

}