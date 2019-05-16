package fr.imie.contact.repositories;

import fr.imie.contact.entities.Person;
import java.util.*;

public class PersonRepositoryMock extends PersonRepository {

    private static Map<Integer, Person> persons = new TreeMap();

    private static int autoIncrement = 1;

    static {
        PersonRepositoryMock mock = new PersonRepositoryMock();
        mock.save(new Person("anakin", "skywalker"));
        mock.save(new Person("luke", "skywalker"));
        mock.save(new Person("leia", "organa"));
    }

    public List<Person> findAll() {
        return new ArrayList(persons.values());
    }

    public void save(Person person) {
        if (person.getId()==null){
            persons.put(autoIncrement, person);
            person.setId(autoIncrement);
            autoIncrement++;
        }else{
            persons.put(person.getId(),person);
        }

    }

    public void deleteById(int id){
        persons.remove(id);
    }

    public Person findById(int id) {
        return persons.get(id);
    }

}