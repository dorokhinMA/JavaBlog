package mdorokhin.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxim Dorokhin
 *         30.04.2016.
 */
public class Post extends BaseEntity {

    private String title;
    private String summary;
    private String body;
    private Category category;
    private List<Comment> comments;

    public Post() {
        this.title = "";
        this.summary = "";
        this.body = "";
        this.category = new Category();
        this.comments = new ArrayList<>();
    }

    public Post(String title, String summary, String body, Category category) {
        this.title = title;
        this.summary = summary;
        this.body = body;
        this.category = category;
        this.comments = new ArrayList<>();
    }

    public Post(String title, String summary, String body, Category category, List<Comment> comments) {
        this.title = title;
        this.summary = summary;
        this.body = body;
        this.category = category;
        this.comments = comments;
    }

    public Post(Integer id, String title, String summary, String body, Category category) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.body = body;
        this.category = category;
        this.comments = new ArrayList<>();
    }

    public Post(Integer id) {
        this.id = id;
        this.title = "";
        this.summary = "";
        this.body = "";
        this.category = new Category();
        this.comments = new ArrayList<>();
    }

    public Post(Integer id, String title, String summary, String body, Category category, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.body = body;
        this.category = category;
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", body='" + body + '\'' +
                ", category=" + category +
                ", comments=" + comments +
                '}';
    }
}
