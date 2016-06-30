package mdorokhin.dao.jdbc.daoImpl;

import mdorokhin.dao.BaseEntityDAO;
import mdorokhin.dao.jdbc.executor.Executor;
import mdorokhin.dao.jdbc.utils.DBUtil;
import mdorokhin.model.BaseEntity;
import mdorokhin.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxim Dorokhin
 *         30.04.2016.
 */
public class JDBCCategoryDAO implements BaseEntityDAO<Category, BaseEntity> {

    private static final Logger log = LoggerFactory.getLogger(JDBCCategoryDAO.class);

    public JDBCCategoryDAO() {}

    @Override
    public void create(Category entity) {

        Connection connection = DBUtil.getConnection();
        Executor executor = new Executor(connection);

        try {
            executor.executeUpdate("insert into categories (title) values ('"+ entity.getTitle() + "')");
        } catch (SQLException e) {
            log.debug("Can't create new category {}", entity);
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

    @Override
    public void delete(Category entity) {

        Connection connection = DBUtil.getConnection();
        Executor executor = new Executor(connection);
        try {
            executor.executeUpdate("delete from categories where id = "+ entity.getId());
        } catch (SQLException e) {
            log.debug("Can't delete category {}", entity);
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

    @Override
    public void edit(Category entity) {

        Connection connection = DBUtil.getConnection();
        Executor executor = new Executor(connection);

        try {
            executor.executeUpdate("update categories set title = '" + entity.getTitle()+ "' where id = "+ entity.getId());
        } catch (SQLException e) {
            log.debug("Can't edit category {}", entity);
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

    @Override
    public Category getById(Integer id) {

        Connection connection = DBUtil.getConnection();
        Executor executor = new Executor(connection);

        try {
            return executor.executeQuery("select * from categories where id=" + id, result -> {
                result.next();
                return new Category(result.getInt(1), result.getString(2));
            });
        } catch (SQLException e) {
            log.debug("Can't get category by id {}", id);
            return null;
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

    @Override
    public List<Category> getAll() {

        List<Category> categories = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        Executor executor = new Executor(connection);

        try {
            return executor.executeQuery("select * from categories", result -> {

                while(result.next()){
                    categories.add(new Category(result.getInt(1), result.getString(2)));}
                return categories ;
            });
        } catch (SQLException e) {
            log.debug("Can't get all categories {}");
            return null;
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

    @Override
    public List<Category> getAll(BaseEntity restriction) {
        return null;
    }

}
