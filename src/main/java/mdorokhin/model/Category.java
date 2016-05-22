package mdorokhin.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxim Dorokhin
 *         30.04.2016.
 */
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Column(name="title", unique = true)
    private String title;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "category")
    private List<Post> posts;

    public Category() {
        this.id = 0;
        this.title = "";
        this.posts = new ArrayList<>();
    }

    public Category(String title) {
        this.title = title;
        this.posts = new ArrayList<>();
    }

    public Category(Integer id, String title) {
        this.id = id;
        this.title = title;
        this.posts = new ArrayList<>();
    }

    public Category(Integer id, String title, List<Post> posts) {
        this.id = id;
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
