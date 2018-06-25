package com.shs.dao.supply;

import com.shs.entity.items.Item;

import java.io.Serializable;

/**
 * <code>DAO</code> For change items.
 *
 * @author Serg Shankunas
 */
public interface CrudDao<K, T extends Serializable> {

    T read(K id);

    /**
     * Adding item.
     *
     * @param entity {@link Item}
     */
    void create(T entity);

    /**
     * Updating item.
     *
     * @param entity {@link Item}
     */
    void update(T entity);

    /**
     * Deleting item.
     *
     * @param id item {@link Item}
     */
    void delete(K id);
}




