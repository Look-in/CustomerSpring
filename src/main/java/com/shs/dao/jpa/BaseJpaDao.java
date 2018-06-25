package com.shs.dao.jpa;

import com.shs.dao.supply.CrudDao;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;


/**
 * Base class with Entity manager and Logger for all DaoClasses.
 *
 * @author Serg Shankunas
 */
@Transactional
public class BaseJpaDao<K extends Number, T extends Serializable> implements CrudDao<K,T> {

    @Autowired
    @Getter
    private SessionFactory sessionFactory;

    @Getter
    private Class<T> type;

    @PostConstruct
    @SuppressWarnings("unchecked")

    protected void initEntityClass() {
        type = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[1];
    }

    protected Session getSession() {
        return getSessionFactory().getCurrentSession();
    }

    @Override
    public T read(K id) {
        return getSession().get(type, id);
    }

    @Override
    public void create(T entity) {
        getSession().save(entity);
    }

    @Override
    public void update(T entity) {
        getSession().merge(entity);
        getSession().flush();
    }

    @Override
    public void delete(K id) {
        getSession().delete(read(id));
    }
}
