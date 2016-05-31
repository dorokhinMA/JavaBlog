package mdorokhin.controller;

import mdorokhin.model.Category;
import mdorokhin.model.Comment;
import mdorokhin.model.Post;
import mdorokhin.service.CategoryService;
import mdorokhin.service.CommentService;
import mdorokhin.service.PostService;
import mdorokhin.service.impl.CategoryServiceImpl;
import mdorokhin.service.impl.CommentServiceImpl;
import mdorokhin.service.impl.PostServiceImpl;

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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String postId = request.getParameter("post");
        String categoryId = request.getParameter("category");
        String action = request.getParameter("action");
        String url = request.getRequestURL().toString();

        if(url.contains("new_post")){
            List<Category> categories = categoryService.getAllCategory();
            request.setAttribute("categories", categories);
            getServletContext().getRequestDispatcher("/jsp/newPost.jsp").forward(request, response);
            return;
        }

        if (postId != null){

            if ("edit".equals(action)){
                Post editablePost = postService.getPostById(Integer.parseInt(postId));
                request.setAttribute("editablePost", editablePost);
                List<Category> categories = categoryService.getAllCategory();
                request.setAttribute("categories", categories);
                getServletContext().getRequestDispatcher("/jsp/newPost.jsp").forward(request, response);

            } else if ("delete".equals(action)) {
                Post delPost = postService.getPostById(Integer.parseInt(postId));
                commentService.deleteCommentsByPost(delPost);
                postService.deletePost(delPost);
                response.sendRedirect("./blog");

            } else {
                Post postById = postService.getPostById(Integer.parseInt(postId));
                List<Comment> allCommentByPost = commentService.getAllCommentByPost(postById);
                request.setAttribute("post", postById);
                request.setAttribute("comments", allCommentByPost);
                getServletContext().getRequestDispatcher("/jsp/post.jsp").forward(request, response);
            }
        } else {

            if (categoryId != null){
                List<Post> allPosts = postService.getAllPostByCategory(categoryService.getCategoryById(Integer.parseInt(categoryId)));
                request.setAttribute("allPosts", allPosts);
                List<Category> allCategory = categoryService.getAllCategory();
                request.setAttribute("categories", allCategory);
                getServletContext().getRequestDispatcher("/jsp/blog.jsp").forward(request,response);
            } else {
                List<Post> allPosts = postService.getAllPost();
                request.setAttribute("allPosts", allPosts);
                List<Category> allCategory = categoryService.getAllCategory();
                request.setAttribute("categories", allCategory);
                getServletContext().getRequestDispatcher("/jsp/blog.jsp").forward(request,response);
            }
        }
                // response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String summary = request.getParameter("summary");
        String body = request.getParameter("body");
        String category = request.getParameter("category");
        String action = request.getParameter("mode");

        if("editable".equals(action)){
            Category categoryById = categoryService.getCategoryById(Integer.parseInt(category));
            postService.editPost(new Post(Integer.parseInt(id), title, summary, body, categoryById));
            response.sendRedirect("./blog");

        } else if ("addComment".equals(action)){
            commentService.addComment(new Comment(body, postService.getPostById(Integer.parseInt(id))));
            response.sendRedirect("./blog?post="+id);

        } else {
            Category categoryById = categoryService.getCategoryById(Integer.parseInt(category));
            postService.addPost(new Post(title, summary, body, categoryById));
            response.sendRedirect("./blog");
        }
    }
}
