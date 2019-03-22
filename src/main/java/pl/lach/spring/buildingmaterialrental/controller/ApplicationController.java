package pl.lach.spring.buildingmaterialrental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.lach.spring.buildingmaterialrental.options.ApplicationOptions;
import pl.lach.spring.buildingmaterialrental.components.category.CategoryService;
import pl.lach.spring.buildingmaterialrental.components.device.DeviceService;
import pl.lach.spring.buildingmaterialrental.components.person.PersonService;

import java.util.Scanner;

@Controller
public class ApplicationController {

    private Scanner scanner;
    private DeviceService deviceService;
    private CategoryService categoryService;
    private PersonService personService;
    private boolean end;

    @Autowired
    public ApplicationController(Scanner scanner, DeviceService deviceService, CategoryService categoryService, PersonService personService) {
        this.scanner = scanner;
        this.deviceService = deviceService;
        this.categoryService = categoryService;
        this.personService = personService;
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
                deviceService.findDeviceById();
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
            case END:
                System.out.println("Bye bye!");
                end = true;
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
