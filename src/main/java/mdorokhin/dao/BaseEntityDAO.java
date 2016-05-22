package mdorokhin.dao;

import mdorokhin.model.BaseEntity;

import java.util.List;

/**
 * @author Maxim Dorokhin
 *         30.04.2016.
 */
public interface BaseEntityDAO<T extends BaseEntity> {

    public void create(T entity);
    public void delete(Integer id);
    public void edit(T entity);
    public T getById(Integer id);
    public List<T> getAll();

}
