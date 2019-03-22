package pl.lach.spring.buildingmaterialrental.components.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lach.spring.buildingmaterialrental.components.category.Category;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByNameContainingIgnoreCase(String name);
}
