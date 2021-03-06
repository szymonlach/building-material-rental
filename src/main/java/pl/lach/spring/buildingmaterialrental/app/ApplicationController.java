package pl.lach.spring.buildingmaterialrental.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.lach.spring.buildingmaterialrental.components.category.CategoryService;
import pl.lach.spring.buildingmaterialrental.components.device.DeviceService;
import pl.lach.spring.buildingmaterialrental.components.person.PersonService;
import pl.lach.spring.buildingmaterialrental.components.rent.RentController;

import java.util.Scanner;

@Controller
public class ApplicationController {

    private Scanner scanner;
    private DeviceService deviceService;
    private CategoryService categoryService;
    private PersonService personService;
    private RentController rentController;
    private boolean end;

    @Autowired
    public ApplicationController(Scanner scanner, DeviceService deviceService, CategoryService categoryService, PersonService personService, RentController rentController) {
        this.scanner = scanner;
        this.deviceService = deviceService;
        this.categoryService = categoryService;
        this.personService = personService;
        this.rentController = rentController;
        end = false;
    }

    public void start() {
        do {
            showMenu();
            int selectedNumber = scanner.nextInt();
            scanner.nextLine();
            handleOption(selectedNumber);
        } while (!end);


    }

    private void handleOption(int selectedONumber) {
        ApplicationOptions selectedOption = ApplicationOptions.convert(selectedONumber);

        switch (selectedOption) {
            case ADD_NEW_DEVICE:
                deviceService.saveDevice();
                break;
            case ADD_NEW_CATEGORY:
                categoryService.saveCategory();
                break;
            case ADD_NEW_PERSON:
                personService.savePerson();
                break;
            case FIND_DEVICE:
                rentController.rentDeviceToCustomer();
                break;
            case REMOVE_DEVICE:
                deviceService.removeDevice();
                break;
            case REMOVE_CATEGORY:
                categoryService.removeCategory();
                break;
            case REMOVE_PERSON:
                personService.removePerson();
                break;
            case FIND_DEVICE_BY_NAME:
                deviceService.findDeviceByName();
                break;
            case END:
                System.out.println("Bye bye!");
                end = true;
                scanner.close();
                break;
        }
    }

    private void showMenu() {
        System.out.println("Options:");
        for (ApplicationOptions option : ApplicationOptions.values()) {
            System.out.println(option);
        }
        System.out.println("Select option ID:");
    }
}
