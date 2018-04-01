/**
 * <code>DAO</code> For reading items attributes<br>
 *
 * @author Serg Shankunas
 */

package com.shs.dao.supply;

import com.shs.entity.Item;

public interface ReadByItem {

    /**
     * Считывает поля объекта Item
     *
     * @param id код товара {@link Item}
     */
    void readItem(Item item);
}




