package SmsBaza.dao;

import SmsBaza.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PesonDaoImp implements PersonDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public long savePerson(Person person) {
        entityManager.persist(person);
        return person.getId();
    }

    @Override
    public Person getPerson(long id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public List<Person> getAllPersons() {
        Query query = entityManager.createQuery("SELECT p FROM Person p");
        return  query.getResultList();
    }

    @Override
    public void updatePerson(Person person) {
        entityManager.merge(person);
    }

    @Override
    public void deletePerson(long id) {
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
    }
}
