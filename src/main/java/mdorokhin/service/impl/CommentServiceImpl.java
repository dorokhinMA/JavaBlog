package mdorokhin.service.impl;

import mdorokhin.dao.BaseEntityDAO;
import mdorokhin.dao.jdbc.JDBCCommentDAO;
import mdorokhin.model.Comment;
import mdorokhin.dao.jdbc.connectservice.ConnectionProviderImpl;
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
    private BaseEntityDAO<Comment> commentDAO;
    private TransactionHelper transactionHelper;

    public CommentServiceImpl() {
        Connection connection = ConnectionProviderImpl.getInstance().getConnection();
        commentDAO = new JDBCCommentDAO(connection);
        this.transactionHelper = new TransactionHelperImpl(connection);
    }

    @Override
    public void addComment(Comment comment) {

        Runnable runnable = ()-> commentDAO.create(comment);
        transactionHelper.doTransaction(runnable);
        log.debug("Comment has been added", comment);
    }

    @Override
    public void deleteComment(Comment comment) {

        Runnable runnable = ()-> commentDAO.delete(comment);
        transactionHelper.doTransaction(runnable);
        log.debug("Comment has been deleted", comment);
    }

    @Override
    public Comment getCommentById(Integer id) {

        Supplier<Comment> supplier = ()-> commentDAO.getById(id);
        return (Comment) transactionHelper.doTransaction(supplier);
    }

    @Override
    public List<Comment> getAllCommentByPost(Post post) {

        Supplier<List<Comment>> supplier = ()-> commentDAO.getAll().stream().filter(comment -> comment.getPost().getId()==post.getId()).collect(Collectors.toList());
        return (List<Comment>) transactionHelper.doTransaction(supplier);
    }


}
