/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * Interface for reading all Item types and
 * item type by Id
 */
package com.shs.dao.reference;

import com.shs.entity.reference.ItemType;

import java.util.List;

public interface ItemTypeDao {

    List<ItemType> readItemTypes();

    ItemType readItemType(int itemTypeId);
}
