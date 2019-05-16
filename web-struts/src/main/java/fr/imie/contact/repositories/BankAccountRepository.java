package fr.imie.contact.repositories;

import fr.imie.contact.entities.*;

import javax.ejb.*;
import javax.persistence.*;
import java.util.*;

@Stateless
public class BankAccountRepository {

    @PersistenceContext
    EntityManager em;

    public List<BankAccount> findAll() {
        return em.createQuery("select ba from BankAccount ba").getResultList();
    }

    public void save(BankAccount entity) {
        if (entity.getId() == null) {
            em.persist(entity);
        }else {
            em.merge(entity);
        }
    }

    public BankAccount findById(Integer id) {
        return em.find(BankAccount.class, id);
    }

}