package SmsBaza.controller;


import SmsBaza.model.Person;
import SmsBaza.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/add_person")
    public ResponseEntity<String> save(@RequestBody Person person) {
        long id = personService.savePerson(person);
        return ResponseEntity.ok().body("Person saved" + id);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> get(@PathVariable("id") long id) {
        Person person = personService.getPerson(id);
        return ResponseEntity.ok().body(person);
    }

    @GetMapping("/all_persons")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personService.getAllPersons();
        return ResponseEntity.ok().body(persons);
    }

    @PutMapping("/update_person")
    public ResponseEntity<?> update(@RequestBody Person person) {
        personService.updatePerson(person);
        return ResponseEntity.ok().body("Book has been updated successfully.");
    }

    @DeleteMapping("/delete_person/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        personService.deletePerson(id);
        return ResponseEntity.ok().body("Person has been deleted successfully.");
    }
}
