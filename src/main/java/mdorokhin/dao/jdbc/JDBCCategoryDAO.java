package mdorokhin.dao.jdbc;

import mdorokhin.dao.BaseEntityDAO;
import mdorokhin.dao.jdbc.executor.Executor;
import mdorokhin.dao.jdbc.executor.ResultHandler;
import mdorokhin.model.Category;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxim Dorokhin
 *         30.04.2016.
 */
public class JDBCCategoryDAO implements BaseEntityDAO<Category> {

    private Executor executor;

    public JDBCCategoryDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    @Override
    public void create(Category entity) {
        try {
            executor.executeUpdate("insert into categories (title) values ('"+ entity.getTitle() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            executor.executeUpdate("delete from categories where id = "+ id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Category entity) {
        try {
            executor.executeUpdate("update categories set title = '" + entity.getTitle()+ "' where id = "+ entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category getById(Integer id) {
        try {
            return executor.executeQuery("select * from categories where id=" + id, new ResultHandler<Category>() {
                @Override
                public Category handle(ResultSet result) throws SQLException {
                    result.next();
                    return new Category(result.getInt(1), result.getString(2));
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Category> getAll() {

        List<Category> categories = new ArrayList<>();

        try {
            return executor.executeQuery("select * from categories", new ResultHandler<List<Category>>() {
                @Override
                public List<Category> handle(ResultSet result) throws SQLException {

                    while(result.next()){
                        categories.add(new Category(result.getInt(1), result.getString(2)));}
                    return categories ;
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }
}
