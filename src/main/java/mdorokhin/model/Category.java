package mdorokhin.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxim Dorokhin
 *         30.04.2016.
 */
public class Category extends BaseEntity {

    private String title;
    private List<Post> posts;

    public Category() {
        this(0, "", new ArrayList<>());
    }

    public Category(String title) {
        this(0, title, new ArrayList<>());
    }

    public Category(Integer id, String title) {
        this(id, title, new ArrayList<>());
    }

    public Category(Integer id, String title, List<Post> posts) {
        super(id);
        this.title = title;
        this.posts = posts;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Category{" +
                "title='" + title + '\'' +
                ", posts=" + posts +
                '}';
    }
}
