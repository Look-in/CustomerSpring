package com.shs.dao.reference;

import com.shs.dao.supply.CrudDao;
import com.shs.entity.reference.ItemType;

import java.util.List;

/**
 * Interface for reading all Item types and
 * item type by Id.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
public interface ItemTypeDao extends CrudDao<Integer, ItemType> {

    List<ItemType> readItemTypes();
}
