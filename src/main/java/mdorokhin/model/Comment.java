package mdorokhin.model;

/**
 * @author Maxim Dorokhin
 *         30.04.2016.
 */
public class Comment extends BaseEntity {

    private String body;
    private Post post;

    public Comment() {
        this(0, "", new Post());
    }

    public Comment(String body) {
        this(0, body, new Post());
    }

    public Comment(String body, Post post) {
        this(0, body, post);
    }

    public Comment(Integer id, String body) {
        this(id, body, new Post());
    }

    public Comment(Integer id, String body, Post post) {
        super(id);
        this.body = body;
        this.post = post;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "body='" + body + '\'' +
                ", post=" + post +
                '}';
    }
}
