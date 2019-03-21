package pl.lach.spring.buildingmaterialrental.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lach.spring.buildingmaterialrental.model.Person;

@Transactional
@Repository
public class PersonDao extends GenericDao<Person, Long> {
}
