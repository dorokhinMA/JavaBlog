package mdorokhin.service;

import mdorokhin.model.Category;
import mdorokhin.model.Post;

import java.util.List;

/**
 * @author Maxim Dorokhin
 *         07.05.2016.
 */
public interface PostService {

    void addPost(Post post);
    void deletePost(Post post);
    void editPost(Post post);
    Post getPostById(Integer Id);
    List<Post> getAllPost();
    List<Post> getAllPostByCategory(Category category);

}
