package mdorokhin.service.impl;

import mdorokhin.dao.BaseEntityDAO;
import mdorokhin.dao.jdbc.daoImpl.JDBCPostDAO;
import mdorokhin.model.BaseEntity;
import mdorokhin.model.Category;
import mdorokhin.model.Post;
import mdorokhin.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Maxim Dorokhin
 *         07.05.2016.
 */
public class PostServiceImpl implements PostService {

    private static final Logger log = LoggerFactory.getLogger(PostServiceImpl.class);
    private BaseEntityDAO<Post, BaseEntity> postDAO;

    public PostServiceImpl() {
        this.postDAO = new JDBCPostDAO();
    }

    public PostServiceImpl(BaseEntityDAO<Post, BaseEntity> postDAO) {
        this.postDAO = postDAO;
    }

    @Override
    public void addPost(Post post) {
        postDAO.create(post);
        log.debug("Post has been added {}", post);
    }

    @Override
    public void deletePost(Post post) {
        postDAO.delete(post);
        log.debug("Post has been deleted {}", post);
    }

    @Override
    public void editPost(Post post) {
        postDAO.edit(post);
        log.debug("Post has been edited {}", post);
    }

    @Override
    public Post getPostById(Integer id) {
        return postDAO.getById(id);
    }

    @Override
    public List<Post> getAllPost() {
        return postDAO.getAll();
    }

    @Override
    public List<Post> getAllPostByCategory(Category category) {
        return postDAO.getAll(category);
    }


}
