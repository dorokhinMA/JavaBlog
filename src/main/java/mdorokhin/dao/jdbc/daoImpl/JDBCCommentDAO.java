package mdorokhin.dao.jdbc.daoImpl;

import mdorokhin.dao.BaseEntityDAO;
import mdorokhin.dao.jdbc.executor.Executor;
import mdorokhin.dao.jdbc.util.DBUtil;
import mdorokhin.model.BaseEntity;
import mdorokhin.model.Comment;
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
public class JDBCCommentDAO implements BaseEntityDAO<Comment, BaseEntity> {

    private static final Logger log = LoggerFactory.getLogger(JDBCCommentDAO.class);

    public JDBCCommentDAO() {}

    @Override
    public void create(Comment entity) {

        Connection connection = DBUtil.getConnection();
        Executor executor = new Executor(connection);

        try {
            executor.executeUpdate("insert into comments (body, post_id) values ('"+ entity.getBody() +"', '"+ entity.getPost().getId() +"')");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

    @Override
    public void delete(Comment entity) {

        Connection connection = DBUtil.getConnection();
        Executor executor = new Executor(connection);

        try {
            executor.executeUpdate("delete from comments where id = "+ entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

    @Override
    public void edit(Comment entity) {

        Connection connection = DBUtil.getConnection();
        Executor executor = new Executor(connection);

        try {
            executor.executeUpdate("update comments set body = '" + entity.getBody()+ "' where id = "+ entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

    @Override
    public Comment getById(Integer id) {

        Connection connection = DBUtil.getConnection();
        Executor executor = new Executor(connection);

        try {
            return executor.executeQuery("select * from comments where id=" + id, result -> {
                result.next();
                return new Comment(result.getInt(1), result.getString(2));
            });
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeConnection(connection);
        }

    }

    @Override
    public List<Comment> getAll() {

        List<Comment> comments = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        Executor executor = new Executor(connection);

        try {
            return executor.executeQuery("select * from comments", result -> {

                while(result.next()){
                    comments.add(new Comment(result.getInt(1), result.getString(2)));}
                return comments ;
            });
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

    @Override
    public List<Comment> getAll(BaseEntity restriction) {

        List<Comment> comments = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        Executor executor = new Executor(connection);

        try {
            return executor.executeQuery("select c.id as com_id, c.body as com_body from comments c where post_id="+ restriction.getId(), result -> {

                while(result.next()){
                    comments.add(new Comment(result.getInt(1), result.getString(2)));}
                return comments ;
            });
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeConnection(connection);
        }
    }
}
