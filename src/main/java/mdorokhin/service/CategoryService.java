package mdorokhin.service;

import mdorokhin.model.Category;

/**
 * @author Maxim Dorokhin
 *         07.05.2016.
 */
public interface CategoryService {

    void addCategory(Category category);
    void deleteCategory(Category category);

}
