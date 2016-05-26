package mdorokhin.controller;

import mdorokhin.model.Category;
import mdorokhin.model.Post;
import mdorokhin.service.CategoryService;
import mdorokhin.service.CommentService;
import mdorokhin.service.PostService;
import mdorokhin.service.impl.CategoryServiceImpl;
import mdorokhin.service.impl.CommentServiceImpl;
import mdorokhin.service.impl.PostServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Maxim Dorokhin
 *         07.05.2016.
 */

public class BlogController extends HttpServlet {

    PostService postService = new PostServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    CommentService commentService = new CommentServiceImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String url = request.getRequestURL().toString();

        if(url.contains("new_post")){
            List<Category> categories = categoryService.getAllCategoryWithPosts();
            request.setAttribute("categories", categories);
            getServletContext().getRequestDispatcher("/jsp/newPost.jsp").forward(request, response);
            return;
        }

        List<Post> allPosts = postService.getAllPost();
        request.setAttribute("allPosts", allPosts);

        List<Category> allCategory = categoryService.getAllCategoryWithPosts();
        request.setAttribute("categories", allCategory);


        getServletContext().getRequestDispatcher("/jsp/blog.jsp").forward(request,response);
        response.setStatus(HttpServletResponse.SC_OK);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
    }
}
