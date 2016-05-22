package mdorokhin.dao.jdbc;

import mdorokhin.dao.BaseEntityDAO;
import mdorokhin.dao.jdbc.executor.Executor;
import mdorokhin.model.Comment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Maxim Dorokhin
 *         30.04.2016.
 */
public class JDBCCommentDAO implements BaseEntityDAO<Comment> {

    private Executor executor;

    public JDBCCommentDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    @Override
    public void create(Comment entity) {
        try {
            executor.executeUpdate("insert into comments (body, post_id) values ('"+ entity.getBody() +"', '"+ entity.getPost().getId() +"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id) {
        try {
            executor.executeUpdate("delete from comments where id = "+ id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void edit(Comment entity) {
        try {
            executor.executeUpdate("update comments set body = '" + entity.getBody()+ "' where id = "+ entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Comment getById(Integer id) {
        return null;
    }

    @Override
    public List<Comment> getAll() {
        return null;
    }
}
