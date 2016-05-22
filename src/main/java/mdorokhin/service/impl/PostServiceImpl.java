package mdorokhin.service.impl;

import mdorokhin.dao.BaseEntityDAO;
import mdorokhin.dao.jdbc.JDBCPostDAO;
import mdorokhin.model.Comment;
import mdorokhin.model.Post;
import mdorokhin.dao.jdbc.connectservice.ConnectionProviderImpl;
import mdorokhin.service.PostService;
import mdorokhin.utils.transactionHelper.TransactionHelper;
import mdorokhin.utils.transactionHelper.TransactionHelperImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Maxim Dorokhin
 *         07.05.2016.
 */
public class PostServiceImpl implements PostService {

    private static final Logger log = LoggerFactory.getLogger(PostServiceImpl.class);
    private BaseEntityDAO<Post> postDAO;
    private TransactionHelper transactionHelper;

    public PostServiceImpl() {
        Connection connection = ConnectionProviderImpl.getInstance().getConnection();
        this.postDAO = new JDBCPostDAO(connection);
        this.transactionHelper = new TransactionHelperImpl(connection);

    }

    @Override
    public void addPost(Post post) {

        Runnable runnable = ()-> postDAO.create(post);
        transactionHelper.doTransaction(runnable);
        log.debug("Post has been added {}", post);
    }

    @Override
    public void deletePost(Post post) {

        Runnable runnable = ()-> postDAO.delete(post);
        transactionHelper.doTransaction(runnable);
        log.debug("Post has been deleted {}", post);
    }

    @Override
    public void editPost(Post post) {

        Runnable runnable = ()-> postDAO.edit(post);
        transactionHelper.doTransaction(runnable);
        log.debug("Post has been edited {}", post);
    }

    @Override
    public Post getPostById(Integer id) {

        Supplier<Post> supplier = ()-> postDAO.getById(id);
        return (Post) transactionHelper.doTransaction(supplier);
    }

    @Override
    public List<Post> getAllPost() {

        Supplier<List<Post>> supplier = ()-> postDAO.getAll();
        return (List<Post>) transactionHelper.doTransaction(supplier);
    }


}
