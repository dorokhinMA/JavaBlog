package mdorokhin.dao.jdbc;

import mdorokhin.dao.BaseEntityDAO;
import mdorokhin.dao.jdbc.executor.Executor;
import mdorokhin.dao.jdbc.executor.ResultHandler;
import mdorokhin.model.Category;
import mdorokhin.model.Comment;
import mdorokhin.model.Post;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxim Dorokhin
 *         30.04.2016.
 */
public class JDBCPostDAO implements BaseEntityDAO<Post> {

    private Executor executor;
    private BaseEntityDAO<Category> categoryDAO;

    public JDBCPostDAO(Connection connection) {
        this.executor = new Executor(connection);
        this.categoryDAO = new JDBCCategoryDAO(connection);
    }

    @Override
    public void create(Post entity) {

        try {
            executor.executeUpdate("insert into posts (title, summary, body, category_id)" +
                    " values ('"+ entity.getTitle() +"', '"+ entity.getSummary() +"', '"+ entity.getBody() +"', '"+ entity.getCategory().getId() +"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Post entity) {

        try {
            executor.executeUpdate("delete from posts where id = "+ entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Post entity) {

        try {
            executor.executeUpdate("update posts set title = '" + entity.getTitle()+ "', summary = '"+ entity.getSummary() +"', body = " +
                    "'"+ entity.getBody() +"', category_id = "+ entity.getCategory().getId() + " where id = "+ entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Post getById(Integer id) {

        try {
            return executor.executeQuery("select * from posts where id=" + id, result -> {
                result.next();
                return new Post(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), categoryDAO.getById(result.getInt(5)));
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Post> getAll() {

        List<Post> posts = new ArrayList<>();

        try {
            return executor.executeQuery("select * from posts", result -> {

                while(result.next()){
                    posts.add(new Post(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), categoryDAO.getById(result.getInt(5))));}
                return posts ;
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
