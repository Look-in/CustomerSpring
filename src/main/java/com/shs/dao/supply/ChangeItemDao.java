package com.shs.dao.supply;

import com.shs.entity.items.Item;

/**
 * <code>DAO</code> For change items.
 *
 * @author Serg Shankunas
 */
public interface ChangeItemDao<T extends Item> {

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
    void delete(int id);
}




