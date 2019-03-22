package pl.lach.spring.buildingmaterialrental.components.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lach.spring.buildingmaterialrental.components.person.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
