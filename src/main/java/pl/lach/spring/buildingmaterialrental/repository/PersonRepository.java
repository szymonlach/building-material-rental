package pl.lach.spring.buildingmaterialrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lach.spring.buildingmaterialrental.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
