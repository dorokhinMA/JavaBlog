package mdorokhin.service.impl;

import mdorokhin.dao.BaseEntityDAO;
import mdorokhin.dao.jdbc.daoImpl.JDBCCategoryDAO;
import mdorokhin.model.BaseEntity;
import mdorokhin.model.Category;
import mdorokhin.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

/**
 * @author Maxim Dorokhin
 *         07.05.2016.
 */
public class CategoryServiceImpl implements CategoryService {

    private static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);
    private BaseEntityDAO<Category, BaseEntity> categoryDAO;

    public CategoryServiceImpl() {
        this.categoryDAO = new JDBCCategoryDAO();
    }

    public CategoryServiceImpl(BaseEntityDAO<Category, BaseEntity> categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public void addCategory(Category category) {
        categoryDAO.create(category);
        log.debug("Category has been added {}", category);
    }

    @Override
    public void deleteCategory(Category category) {
        categoryDAO.delete(category);
    }

    @Override
    public void editCategory(Category category) {
        categoryDAO.edit(category);
        log.debug("Category has been edited {}", category);
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryDAO.getById(id);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryDAO.getAll();
    }


}
