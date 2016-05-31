package mdorokhin.service;

import mdorokhin.model.Category;

import java.util.List;

/**
 * @author Maxim Dorokhin
 *         07.05.2016.
 */
public interface CategoryService {

    void addCategory(Category category);
    void deleteCategory(Category category);
    void editCategory(Category category);
    Category getCategoryById(Integer id);
    List<Category> getAllCategory();

}
