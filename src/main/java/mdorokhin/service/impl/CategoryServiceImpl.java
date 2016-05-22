package mdorokhin.service.impl;

import mdorokhin.dao.BaseEntityDAO;
import mdorokhin.dao.jdbc.JDBCCategoryDAO;
import mdorokhin.model.Category;
import mdorokhin.dao.jdbc.connectservice.ConnectionProviderImpl;
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
    private BaseEntityDAO<Category> categoryDAO;
    private TransactionHelper transactionHelper;

    public CategoryServiceImpl() {
        Connection connection = ConnectionProviderImpl.getInstance().getConnection();
        this.categoryDAO = new JDBCCategoryDAO(connection);
        this.transactionHelper = new TransactionHelperImpl(connection);
    }

    @Override
    public void addCategory(Category category) {

        Runnable runnable = ()-> categoryDAO.create(category);
        transactionHelper.doTransaction(runnable);
        log.debug("Category has been added {}", category);
    }

    @Override
    public void deleteCategory(Category category) {

        Runnable runnable = ()-> categoryDAO.delete(category);
        transactionHelper.doTransaction(runnable);
        log.debug("Category has been deleted {}", category);
    }

    @Override
    public Category getCategoryById(Integer id) {

        Supplier<Category> supplier = ()-> categoryDAO.getById(id);
        return (Category) transactionHelper.doTransaction(supplier);
    }

    @Override
    public List<Category> getAllCategory() {

        Supplier<List<Category>> supplier = ()-> categoryDAO.getAll();
        return (List<Category>) transactionHelper.doTransaction(supplier);
    }


}
