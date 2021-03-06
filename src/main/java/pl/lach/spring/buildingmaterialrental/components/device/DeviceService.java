package pl.lach.spring.buildingmaterialrental.components.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.lach.spring.buildingmaterialrental.components.category.Category;
import pl.lach.spring.buildingmaterialrental.components.category.CategoryRepository;

import java.math.BigDecimal;
import java.util.List;
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
        scanner.nextLine();
        System.out.println("Category name");
        String categoryName = scanner.nextLine();
        Device device = new Device(name, quantity, BigDecimal.valueOf(price));
        Optional<Category> category = categoryRepository.findByNameContainingIgnoreCase(categoryName);
        category.ifPresent(device::setCategory);
        deviceRepository.save(device);
        System.out.println("Device added!");
    }


    public void removeDevice() {
        System.out.println("Type device Id to remove");
        long id = scanner.nextLong();
        Optional<Device> device = deviceRepository.findById(id);
        device.ifPresentOrElse(deviceRepository::delete,()-> System.out.println("NO SUCH DEVICE!"));
        System.out.println("Device remove!");
    }

    public void findDeviceByName() {
        System.out.println("Type device name");
        String name = scanner.nextLine();
        List<Device> devices = deviceRepository.findAllByNameContainingIgnoreCase(name);
        devices.forEach(System.out::println);
    }
}
