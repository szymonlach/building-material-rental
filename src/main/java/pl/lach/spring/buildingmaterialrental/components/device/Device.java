package pl.lach.spring.buildingmaterialrental.components.device;

import pl.lach.spring.buildingmaterialrental.components.category.Category;
import pl.lach.spring.buildingmaterialrental.components.person.Person;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer quantity;
    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "device_person",
            joinColumns = {@JoinColumn(name = "device_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "person_id", referencedColumnName = "id")})
    private List<Person> personList = new ArrayList<>();


    public Device(String name, Integer quantity, BigDecimal price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Device() {
    }

    public Long getId() {
        return id;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void addPerson(Person person){
        person.getDevices().add(this);
        personList.add(person);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Device)) return false;
        Device device = (Device) o;
        return Objects.equals(getId(), device.getId()) &&
                Objects.equals(getName(), device.getName()) &&
                Objects.equals(getQuantity(), device.getQuantity()) &&
                Objects.equals(getPrice(), device.getPrice()) &&
                Objects.equals(getCategory(), device.getCategory());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName(), getQuantity(), getPrice(), getCategory());
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", category=" + category +
                ", personList=" + personList +
                '}';
    }
}
