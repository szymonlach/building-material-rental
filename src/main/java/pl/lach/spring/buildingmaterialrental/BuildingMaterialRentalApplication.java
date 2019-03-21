package pl.lach.spring.buildingmaterialrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.lach.spring.buildingmaterialrental.model.Category;
import pl.lach.spring.buildingmaterialrental.model.Device;
import pl.lach.spring.buildingmaterialrental.model.Person;
import pl.lach.spring.buildingmaterialrental.repository.DeviceRepository;

import java.math.BigDecimal;

@SpringBootApplication
public class BuildingMaterialRentalApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BuildingMaterialRentalApplication.class, args);


        Category category = new Category("Tools", "Some tools");
        Device device = new Device("Drill", 3, BigDecimal.valueOf(40));
        Person person = new Person("Mark", "Nowak", "81938194019", "812");


        device.setCategory(category);
        device.addPerson(person);

        DeviceRepository deviceRepository = context.getBean(DeviceRepository.class);
        deviceRepository.save(device);
        System.out.println(device);

    }

}
