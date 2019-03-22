package pl.lach.spring.buildingmaterialrental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lach.spring.buildingmaterialrental.model.Category;
import pl.lach.spring.buildingmaterialrental.repository.CategoryRepository;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CategoryService {

    private Scanner scanner;
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(Scanner scanner, CategoryRepository categoryRepository) {
        this.scanner = scanner;
        this.categoryRepository = categoryRepository;
    }

    public void saveCategory() {
        System.out.println("Category name:");
        String name = scanner.nextLine();
        System.out.println("Description:");
        String description = scanner.nextLine();
        categoryRepository.save(new Category(name, description));
        System.out.println("Category added!");
    }

    public void removeCategory() {
        System.out.println("Type category Id to remove:");
        long id = scanner.nextLong();
        Optional<Category> category = categoryRepository.findById(id);
        category.ifPresent(categoryRepository::delete);
        System.out.println("Category removed!");
    }
}
