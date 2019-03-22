package pl.lach.spring.buildingmaterialrental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.lach.spring.buildingmaterialrental.model.Category;
import pl.lach.spring.buildingmaterialrental.model.Device;
import pl.lach.spring.buildingmaterialrental.repository.CategoryRepository;
import pl.lach.spring.buildingmaterialrental.repository.DeviceRepository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

@Service
public class DeviceService {

    private Scanner scanner;
    private DeviceRepository deviceRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public DeviceService(Scanner scanner, DeviceRepository deviceRepository, CategoryRepository categoryRepository) {
        this.scanner = scanner;
        this.deviceRepository = deviceRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void saveDevice() {
        System.out.println("Device name:");
        String name = scanner.nextLine();
        System.out.println("Price:");
        double price = scanner.nextDouble();
        System.out.println("Quantity");
        int quantity = scanner.nextInt();
        System.out.println("Category ID");
        Long cateoryID = scanner.nextLong();
        Device device = new Device(name, quantity, BigDecimal.valueOf(price));
        Optional<Category> byId = categoryRepository.findById(cateoryID);
        byId.ifPresent(device::setCategory);
        deviceRepository.save(device);
        System.out.println("Device added!");
    }

    public void findDeviceById() {
        System.out.println("Type device ID:");
        long id = scanner.nextLong();

        System.out.println(deviceRepository.findById(id));
    }

    public void removeDevice() {
        System.out.println("Type device Id to remove");
        long id = scanner.nextLong();
        Optional<Device> device = deviceRepository.findById(id);
        device.ifPresent(deviceRepository::delete);
        System.out.println("Device remove!");
    }
}
