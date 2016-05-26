package mdorokhin.service.impl;

import mdorokhin.dao.BaseEntityDAO;
import mdorokhin.dao.jdbc.daoImpl.JDBCCategoryDAO;
import mdorokhin.model.BaseEntity;
import mdorokhin.model.Category;
import mdorokhin.dao.jdbc.pool.TomcatPool;
import mdorokhin.service.CategoryService;
import mdorokhin.utils.transactionHelper.TransactionHelper;
import mdorokhin.utils.transactionHelper.TransactionHelperImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.List;
import java.util.function.Supplier;

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

    @Override
    public void addCategory(Category category) {

        categoryDAO.create(category);
        log.debug("Category has been added {}", category);
    }

    @Override
    public void deleteCategoryWithPosts(Category category) {

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
    public List<Category> getAllCategoryWithPosts() {
        return categoryDAO.getAll();
    }



}
