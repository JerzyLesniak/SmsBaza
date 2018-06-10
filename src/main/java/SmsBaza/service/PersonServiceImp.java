package SmsBaza.service;

import SmsBaza.dao.PersonDao;
import SmsBaza.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class PersonServiceImp implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Transactional
    @Override
    public long savePerson(Person person) {
        return personDao.savePerson(person);
    }

    @Override
    public Person getPerson(long id) {
        return personDao.getPerson(id);
    }

    @Override
    public List<Person> getAllPersons() {
        return personDao.getAllPersons();
    }

    @Transactional
    @Override
    public void updatePerson(Person person) {
        personDao.updatePerson(person);
    }

    @Override
    public void deletePerson(long id) {
        personDao.deletePerson(id);
    }
}
