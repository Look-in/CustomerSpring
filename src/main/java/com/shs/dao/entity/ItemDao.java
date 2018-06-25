package com.shs.dao.entity;

import com.shs.dao.supply.CrudDao;
import com.shs.entity.items.Item;

import java.util.List;

/**
 * <code>DAO</code> For reading items attributes.
 *
 * @author Serg Shankunas
 */
public interface ItemDao<T extends Item> extends CrudDao<Integer, T> {

    List<T> readListItem(int itemType);
}




