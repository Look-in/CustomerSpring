package com.shs.dao.supply;

import com.shs.entity.items.Item;

import java.util.List;

/**
 * <code>DAO</code> For reading list of items.
 *
 * @author Serg Shankunas
 */
public interface ReadListItemsDao {

    List<Item> readListItem(int itemType);
}




