package com.shs.dao.supply;

import com.shs.entity.items.Item;

/**
 * <code>DAO</code> For reading items attributes.
 *
 * @author Serg Shankunas
 */
public interface ReadItemDao<T extends Item> {

    /**
     * Reading the attributes of the Item.
     *
     * @param itemId Item code {@link Item}
     */
    T readItem(int itemId);
}




