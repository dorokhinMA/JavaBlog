package mdorokhin.service.impl;

import mdorokhin.dao.BaseEntityDAO;
import mdorokhin.dao.jdbc.JDBCCommentDAO;
import mdorokhin.model.Comment;
import mdorokhin.dao.jdbc.connectservice.ConnectionProviderImpl;
import mdorokhin.service.CommentService;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Maxim Dorokhin
 *         07.05.2016.
 */
public class CommentServiceImpl implements CommentService {

    private final Connection connection;
    private BaseEntityDAO<Comment> commentDAO;

    public CommentServiceImpl() {
        this.connection = ConnectionProviderImpl.getInstance().getConnection();
        commentDAO = new JDBCCommentDAO(connection);
    }

    @Override
    public void addComment(Comment comment) {
        try {
            connection.setAutoCommit(false);
            commentDAO.create(comment);
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {
                System.out.println(ignore.getErrorCode());
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {
            }
        }
    }

    @Override
    public void deleteComment(Comment comment) {
        try {
            connection.setAutoCommit(false);
            commentDAO.delete(comment.getId());
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {
                System.out.println(ignore.getErrorCode());
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {
            }
        }
    }
}
