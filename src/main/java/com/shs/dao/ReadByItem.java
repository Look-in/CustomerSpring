/**
 * <code>DAO</code> For reading items attributes<br>
 *
 * @author Serg Shankunas
 */

package com.shs.dao;

import com.shs.entity.event.Item;

public interface ReadByItem {

    /**
     * Считывает поля объекта Item
     *
     * @param id код товара {@link Item}
     */
    void readItem(Item item);
}




