/**
 * <code>DAO</code> For change items<br>
 *
 * @author Serg Shankunas
 */
package com.shs.dao.supply;

import com.shs.entity.items.Item;

public interface ChangeItemDao<T extends Item> {

    /**
     * Adding item.
     * @param entity  {@link Item}
     */
    void create(T entity);

    /**
     * Updating item.
     * @param entity {@link Item}
     */
    void update(T entity);

    /**
     * Deleting item.
     * @param id item {@link Item}
     */
    void delete(int id);
}




