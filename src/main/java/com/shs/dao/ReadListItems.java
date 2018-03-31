/**
 * <code>DAO</code> For reading list of items<br>
 *
 * @author Serg Shankunas
 */
package com.shs.dao;

import com.shs.entity.event.Item;

import java.util.List;

public interface ReadListItems {

    List<Item> readListItem(int itemType);
}




