/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * Interface for reading all Item types and
 * item type by Id
 */
package com.shs.service.reference;

import com.shs.entity.reference.ItemType;

import java.util.List;

public interface ItemTypeService {

    List<ItemType> getItemTypes();

    ItemType getItemType(int itemTypeId);
}
