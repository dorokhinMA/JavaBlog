package mdorokhin.service.impl;

import mdorokhin.dao.BaseEntityDAO;
import mdorokhin.dao.jdbc.daoImpl.JDBCCommentDAO;
import mdorokhin.model.BaseEntity;
import mdorokhin.model.Comment;
import mdorokhin.dao.jdbc.pool.TomcatPool;
import mdorokhin.model.Post;
import mdorokhin.service.CommentService;
import mdorokhin.utils.transactionHelper.TransactionHelper;
import mdorokhin.utils.transactionHelper.TransactionHelperImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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
    public Comment getCommentById(Integer id) {

        return commentDAO.getById(id);
    }

    @Override
    public List<Comment> getAllCommentByPost(Post post) {

     //   commentDAO.getAll().stream().filter(comment -> comment.getPost().getId()==post.getId()).collect(Collectors.toList());
        return commentDAO.getAll(post);
    }


}
