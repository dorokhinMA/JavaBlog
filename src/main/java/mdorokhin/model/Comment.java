package mdorokhin.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * @author Maxim Dorokhin
 *         30.04.2016.
 */
@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {

    @Column(name="body")
    @Type(type="text")
    private String body;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Post post;

    public Comment() {
        this.body = "";
        this.post = new Post();
    }

    public Comment(String body) {
        this.body = body;
        this.post = new Post();
    }

    public Comment(String body, Post post) {
        this.body = body;
        this.post = post;
    }

    public Comment(Integer id, String body) {
        this.id = id;
        this.body = body;
        this.post = new Post();
    }

    public Comment(Integer id, String body, Post post) {
        this.id = id;
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
