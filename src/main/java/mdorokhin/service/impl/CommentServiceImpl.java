package mdorokhin.service.impl;

import mdorokhin.dao.BaseEntityDAO;
import mdorokhin.dao.jdbc.daoImpl.JDBCCommentDAO;
import mdorokhin.model.BaseEntity;
import mdorokhin.model.Comment;
import mdorokhin.model.Post;
import mdorokhin.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

/**
 * @author Maxim Dorokhin
 *         07.05.2016.
 */
public class CommentServiceImpl implements CommentService {

    private static final Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);
    private BaseEntityDAO<Comment, BaseEntity> commentDAO;

    public CommentServiceImpl() {
        commentDAO = new JDBCCommentDAO();
    }

    @Override
    public void addComment(Comment comment) {

        commentDAO.create(comment);
        log.debug("Comment has been added", comment);
    }

    @Override
    public void deleteComment(Comment comment) {

        commentDAO.delete(comment);
        log.debug("Comment has been deleted", comment);
    }

    @Override
    public void deleteCommentsByPost(Post post) {

        commentDAO.getAll(post).forEach(this::deleteComment);
    }

    @Override
    public Comment getCommentById(Integer id) {

        return commentDAO.getById(id);
    }

    @Override
    public List<Comment> getAllCommentByPost(Post post) {

        return commentDAO.getAll(post);
    }

    @Override
    public List<Comment> getAll() {

        return commentDAO.getAll();
    }


}
