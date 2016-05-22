package mdorokhin.service;

import mdorokhin.model.Comment;

/**
 * @author Maxim Dorokhin
 *         07.05.2016.
 */
public interface CommentService {

    void addComment(Comment comment);
    void deleteComment(Comment comment);

}
