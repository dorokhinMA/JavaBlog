package mdorokhin.service;

import mdorokhin.model.Post;

/**
 * @author Maxim Dorokhin
 *         07.05.2016.
 */
public interface PostService {

    void addPost(Post post);
    void deletePost(Post post);
    void editPost(Post post);

}
