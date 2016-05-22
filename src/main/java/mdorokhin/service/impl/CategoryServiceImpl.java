package mdorokhin.service.impl;

import mdorokhin.dao.BaseEntityDAO;
import mdorokhin.dao.jdbc.JDBCCategoryDAO;
import mdorokhin.model.Category;
import mdorokhin.dao.jdbc.connectservice.ConnectionProviderImpl;
import mdorokhin.service.CategoryService;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Maxim Dorokhin
 *         07.05.2016.
 */
public class CategoryServiceImpl implements CategoryService {

    private final Connection connection;
    private BaseEntityDAO<Category> categoryDAO;

    public CategoryServiceImpl() {
        this.connection = ConnectionProviderImpl.getInstance().getConnection();
        categoryDAO = new JDBCCategoryDAO(connection);
    }

    @Override
    public void addCategory(Category category) {

        try {
            connection.setAutoCommit(false);
            categoryDAO.create(category);
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {

            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {
            }
        }
    }

    @Override
    public void deleteCategory(Category category) {
        try {
            connection.setAutoCommit(false);
            categoryDAO.delete(category.getId());
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {

            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {
            }
        }
    }
}
