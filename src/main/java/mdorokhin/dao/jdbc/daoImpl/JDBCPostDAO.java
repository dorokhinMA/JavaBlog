package mdorokhin.dao.jdbc.daoImpl;

import mdorokhin.dao.BaseEntityDAO;
import mdorokhin.dao.jdbc.executor.Executor;
import mdorokhin.dao.jdbc.utils.DBUtil;
import mdorokhin.model.BaseEntity;
import mdorokhin.model.Category;
import mdorokhin.model.Post;
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
public class JDBCPostDAO implements BaseEntityDAO<Post, BaseEntity> {

    private static final Logger log = LoggerFactory.getLogger(JDBCPostDAO.class);

    public JDBCPostDAO() {}

    @Override
    public void create(Post entity) {

        Connection connection = DBUtil.getConnection();
        Executor executor = new Executor(connection);

        try {
            executor.executeUpdate("insert into posts (title, summary, body, category_id)" +
                    " values ('"+ entity.getTitle() +"', '"+ entity.getSummary() +"', '"+ entity.getBody() +"', '"+ entity.getCategory().getId() +"')");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

    @Override
    public void delete(Post entity) {

        Connection connection = DBUtil.getConnection();
        Executor executor = new Executor(connection);

        try {
            executor.executeUpdate("delete from posts where id = "+ entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

    @Override
    public void edit(Post entity) {

        Connection connection = DBUtil.getConnection();
        Executor executor = new Executor(connection);

        try {
            executor.executeUpdate("update posts set title = '" + entity.getTitle()+ "', summary = '"+ entity.getSummary() +"', body = " +
                    "'"+ entity.getBody() +"', category_id = "+ entity.getCategory().getId() + " where id = "+ entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

    @Override
    public Post getById(Integer id) {

        Connection connection = DBUtil.getConnection();
        Executor executor = new Executor(connection);

        try {
            return executor.executeQuery("select p.id as post_id, p.title as post_title, summary, p.body as post_body, c.id as cat_id, c.title as cat_title  from posts p inner join categories c on p.category_id = c.id where p.id=" + id, result -> {
                result.next();
                return new Post(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), new Category(result.getInt(5), result.getString(6)));
            });
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

    @Override
    public List<Post> getAll() {

        List<Post> posts = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        Executor executor = new Executor(connection);

        try {
            return executor.executeQuery("select p.id as post_id, p.title as post_title, summary, p.body as post_body, c.id as cat_id, c.title as cat_title  from posts p inner join categories c on p.category_id = c.id", result -> {
                while(result.next()){
                    posts.add(new Post(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), new Category(result.getInt(5), result.getString(6))));}
                return posts ;
            });
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

    @Override
    public List<Post> getAll(BaseEntity restriction) {
        List<Post> posts = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        Executor executor = new Executor(connection);

        try {
            return executor.executeQuery("select p.id as post_id, p.title as post_title, summary, p.body as post_body, c.id as cat_id, c.title as cat_title  from posts p inner join categories c on p.category_id = c.id where category_id="+ restriction.getId(), result -> {

                while(result.next()){
                    posts.add(new Post(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), new Category(result.getInt(5), result.getString(6))));}
                return posts ;
            });
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeConnection(connection);
        }
    }


}
