/**
 * <code>DAO</code> For reading items attributes<br>
 *
 * @author Serg Shankunas
 */

package com.shs.dao.supply;

import com.shs.entity.Item;

public interface ReadItem<T extends Item> {

    /**
     * Считывает поля объекта Item
     *
     * @param id код товара {@link Item}
     */
    T readItem(int itemId);
}



