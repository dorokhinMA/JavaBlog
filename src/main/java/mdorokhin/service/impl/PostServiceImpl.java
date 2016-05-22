package mdorokhin.service.impl;

import mdorokhin.dao.BaseEntityDAO;
import mdorokhin.dao.jdbc.JDBCPostDAO;
import mdorokhin.model.Post;
import mdorokhin.dao.jdbc.connectservice.ConnectionProviderImpl;
import mdorokhin.service.PostService;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Maxim Dorokhin
 *         07.05.2016.
 */
public class PostServiceImpl implements PostService {

    private final Connection connection;
    private BaseEntityDAO<Post> postDAO;

    public PostServiceImpl() {
        this.connection = ConnectionProviderImpl.getInstance().getConnection();
        postDAO = new JDBCPostDAO(connection);
    }


    @Override
    public void addPost(Post post) {
        try {
            connection.setAutoCommit(false);
            postDAO.create(post);
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
    public void deletePost(Post post) {
        try {
            connection.setAutoCommit(false);
            postDAO.delete(post.getId());
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
    public void editPost(Post post) {
        try {
            connection.setAutoCommit(false);
            postDAO.edit(post);
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
