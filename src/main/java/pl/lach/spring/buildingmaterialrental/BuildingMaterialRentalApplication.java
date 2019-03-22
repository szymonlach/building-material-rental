package pl.lach.spring.buildingmaterialrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import pl.lach.spring.buildingmaterialrental.controller.ApplicationController;

import java.util.Scanner;

@SpringBootApplication
public class BuildingMaterialRentalApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BuildingMaterialRentalApplication.class, args);

        ApplicationController applicationController = context.getBean(ApplicationController.class);
        applicationController.start();

//        Category category = new Category("Tools", "Some tools");
//        Device device = new Device("Drill", 3, BigDecimal.valueOf(40));
//        Person person = new Person("Mark", "Nowak", "81938194019", "812");
//
//
//        device.setCategory(category);
//        device.addPerson(person);
//
//        DeviceRepository deviceRepository = context.getBean(DeviceRepository.class);
//        deviceRepository.save(device);
//        System.out.println(device);

    }


    @Bean
    public Scanner getScanner() {
        return new Scanner(System.in);
    }

}
