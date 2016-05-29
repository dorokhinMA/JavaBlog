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



}
