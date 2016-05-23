package mdorokhin.dao;

import mdorokhin.model.BaseEntity;

import java.util.List;

/**
 * @author Maxim Dorokhin
 *         30.04.2016.
 */
public interface BaseEntityDAO<T extends BaseEntity, V extends BaseEntity> {

     void create(T entity);
     void delete(T entity);
     void edit(T entity);
     T getById(Integer id);
     List<T> getAll();
     List<T> getAll(V restriction);
}
