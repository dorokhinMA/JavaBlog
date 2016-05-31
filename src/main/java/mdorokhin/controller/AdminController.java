package mdorokhin.controller;

import mdorokhin.model.Category;
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
 *         30.05.2016.
 */
public class AdminController extends HttpServlet {

    PostService postService = new PostServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    CommentService commentService = new CommentServiceImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String mode = request.getParameter("mode");
        String action = request.getParameter("action");
        String categoryId = request.getParameter("category");

        if ("categories".equals(mode) || categoryId != null){

            if("edit".equals(action)){
                categoryService.editCategory(categoryService.getCategoryById(Integer.parseInt(categoryId)));
                response.sendRedirect("./admin?mode=categories");
            } else if ("delete".equals(action)){
                Category categoryById = categoryService.getCategoryById(Integer.parseInt(categoryId));
                postService.getAllPostByCategory(categoryById).forEach((a)-> postService.deletePost(a));
                categoryService.deleteCategory(categoryById);
                response.sendRedirect("./admin?mode=categories");

            } else {

                List<Category> allCategories = categoryService.getAllCategory();
                request.setAttribute("allCategories", allCategories);
                getServletContext().getRequestDispatcher("/jsp/admin/categories_page.jsp").forward(request, response);
                response.setStatus(HttpServletResponse.SC_OK);
            }

        } else if ("posts".equals(mode)){

            getServletContext().getRequestDispatcher("/jsp/admin/posts_page.jsp").forward(request, response);
            response.setStatus(HttpServletResponse.SC_OK);

        } else if ("comments".equals(mode)){

            getServletContext().getRequestDispatcher("/jsp/admin/comments_page.jsp").forward(request, response);
            response.setStatus(HttpServletResponse.SC_OK);

        } else {
            getServletContext().getRequestDispatcher("/jsp/admin/admin_page.jsp").forward(request, response);
            response.setStatus(HttpServletResponse.SC_OK);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        String title = request.getParameter("title");

        if("addCategory".equals(action)){
            categoryService.addCategory(new Category(title));
            response.sendRedirect("./admin?mode=categories");
        }


    }
}
