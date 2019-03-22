package pl.lach.spring.buildingmaterialrental.components.rent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import pl.lach.spring.buildingmaterialrental.components.device.Device;
import pl.lach.spring.buildingmaterialrental.components.device.DeviceRepository;
import pl.lach.spring.buildingmaterialrental.components.person.Person;
import pl.lach.spring.buildingmaterialrental.components.person.PersonRepository;

import java.util.Optional;
import java.util.Scanner;


@Controller
public class RentController {

    private Scanner scanner;
    private DeviceRepository deviceRepository;
    private PersonRepository personRepository;

    @Autowired
    public RentController(Scanner scanner, DeviceRepository deviceRepository, PersonRepository personRepository) {
        this.scanner = scanner;
        this.deviceRepository = deviceRepository;
        this.personRepository = personRepository;
    }

    @Transactional
    public void rentDeviceToCustomer() {
        try {
            rent();
        } catch (RentException exception) {
            System.err.println(exception.getMessage());
        }
    }


    private void rent() {
        System.out.println("Type person ID");
        long personId = scanner.nextLong();
        System.out.println("Type device ID");
        long deviceID = scanner.nextLong();
        Optional<Person> person = personRepository.findById(personId);
        Optional<Device> device = deviceRepository.findById(deviceID);

        if (person.isPresent())
            device.ifPresentOrElse(dev -> {
                if (dev.getQuantity() > dev.getPersonList().size())
                    dev.addPerson(person.get());
                else throw new RentException("No free devices");
            }, () -> {
                throw new RentException("There is no such device");
            });
        else
            throw new RentException("There is no such person");
    }
}
