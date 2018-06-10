package SmsBaza.service;

import SmsBaza.model.Person;

import java.util.List;

public interface PersonService {

    long savePerson(Person person);
    Person getPerson(long id);
    List<Person> getAllPersons();
    void updatePerson(Person person);
    void deletePerson(long id);
}
