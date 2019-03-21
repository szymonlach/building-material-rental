package pl.lach.spring.buildingmaterialrental.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lach.spring.buildingmaterialrental.model.Category;

@Transactional
@Repository
public class CategoryDao extends GenericDao<Category, Long> {
}
