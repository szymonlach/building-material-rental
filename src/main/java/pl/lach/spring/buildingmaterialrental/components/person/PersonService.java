package pl.lach.spring.buildingmaterialrental.components.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lach.spring.buildingmaterialrental.components.person.Person;
import pl.lach.spring.buildingmaterialrental.components.person.PersonRepository;

import java.util.Optional;
import java.util.Scanner;

@Service
public class PersonService {

    private Scanner scanner;
    private PersonRepository personRepository;

    @Autowired
    public PersonService(Scanner scanner, PersonRepository personRepository) {
        this.scanner = scanner;
        this.personRepository = personRepository;
    }

    public void savePerson() {
        System.out.println("First name:");
        String firstName = scanner.nextLine();
        System.out.println("Last name:");
        String lastName = scanner.nextLine();
        System.out.println("PESEL:");
        String pesel = scanner.nextLine();
        System.out.println("Card id:");
        String cardId = scanner.nextLine();

        personRepository.save(new Person(firstName, lastName, pesel, cardId));
        System.out.println("Person added!");
    }

    public void removePerson() {
        System.out.println("Type person Id to remove");
        long id = scanner.nextLong();
        Optional<Person> person = personRepository.findById(id);
        person.ifPresent(personRepository::delete);
        System.out.println("Person remove!");
    }
}
