/**
 * <code>DAO</code> For reading items attributes<br>
 *
 * @author Serg Shankunas
 */

package com.shs.dao;

import com.shs.entity.event.Item;

public interface ReadItem<T extends Item> {

    /**
     * Считывает поля объекта Item
     *
     * @param id код товара {@link Item}
     */
    T readItem(int itemId);
}




