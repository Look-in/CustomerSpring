/**
 * <code>DAO</code> For reading items attributes<br>
 *
 * @author Serg Shankunas
 */
package com.shs.dao.supply;

import com.shs.entity.items.Item;

public interface ReadItemDao<T extends Item> {

    /**
     * Reading the attributes of the Item
     * @param itemId  Item code {@link Item}
     */
    T readItem(int itemId);
}




