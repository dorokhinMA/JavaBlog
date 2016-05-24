package mdorokhin.main;

import mdorokhin.dao.BaseEntityDAO;
import mdorokhin.dao.jdbc.daoImpl.JDBCCategoryDAO;
import mdorokhin.dao.jdbc.daoImpl.JDBCPostDAO;
import mdorokhin.model.Category;
import mdorokhin.model.Comment;
import mdorokhin.model.Post;
import mdorokhin.service.CategoryService;
import mdorokhin.service.CommentService;
import mdorokhin.service.PostService;
import mdorokhin.service.impl.CategoryServiceImpl;
import mdorokhin.service.impl.CommentServiceImpl;
import mdorokhin.service.impl.PostServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Maxim Dorokhin
 *         30.04.2016.
 */
public class Main {

//    private static SessionFactory sessionFactory;
//    private static ServiceRegistry serviceRegistry;
//
//    private static void init() {
//        Configuration configuration = new Configuration();
//        configuration.configure("hibernate/hibernate.cfg.xml");
//        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//    }
//
//    public static void main(String[] args) throws SQLException {
//        init();
//
//        Session s = sessionFactory.getCurrentSession();
//        s.beginTransaction();
//
//        List<Post> posts = s.createQuery("from Post").list();
//
//        for (Post p: posts){
//
//            System.out.println(p);
//        }
//
//        s.getTransaction().commit();


    public static void main(String[] args) {

//        PostService postService = new PostServiceImpl();
//        Post post1 = postService.getPostById(1);
//      //  System.out.println(post1);
//        CommentService commentService = new CommentServiceImpl();
//        List<Comment> allCommentByPost = commentService.getAllCommentByPost(post1);
//
//        allCommentByPost.forEach(System.out::println);

//        CategoryService categoryService = new CategoryServiceImpl();
//        Category category2 = categoryService.getCategoryById(2);
//        PostService postService = new PostServiceImpl();
//        List<Post> allPostByCategory = postService.getAllPostByCategory(category2);
//
//        allPostByCategory.forEach(System.out::println);
    }
}
