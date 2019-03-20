package pl.lach.spring.buildingmaterialrental.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(length = 11)
    private String pesel;
    private String idCardNumber;

    @ManyToMany
    private List<Device> devices;
}
