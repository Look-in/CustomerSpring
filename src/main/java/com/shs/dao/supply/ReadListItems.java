/**
 * <code>DAO</code> For reading list of items<br>
 *
 * @author Serg Shankunas
 */
package com.shs.dao.supply;

import com.shs.entity.Item;

import java.util.List;

public interface ReadListItems {

    List<Item> readListItem(int itemType);
}




