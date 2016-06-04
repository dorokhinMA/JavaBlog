package mdorokhin.service;

import mdorokhin.model.Comment;
import mdorokhin.model.Post;

import java.util.List;

/**
 * @author Maxim Dorokhin
 *         07.05.2016.
 */
public interface CommentService {

    void addComment(Comment comment);
    void deleteComment(Comment comment);
    void deleteCommentsByPost(Post post);
    Comment getCommentById(Integer id);
    List<Comment> getAllCommentByPost(Post post);
    List<Comment> getAll();

}
