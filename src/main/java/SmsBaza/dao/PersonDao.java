package SmsBaza.dao;

import SmsBaza.model.Person;
import java.util.List;

public interface PersonDao {

    long savePerson(Person person);
    Person getPerson(long id);
    List<Person> getAllPersons();
    void updatePerson(Person person);
    void deletePerson(long id);
}
