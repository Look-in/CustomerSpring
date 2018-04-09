package com.shs.service.reference;

import com.shs.entity.reference.ItemType;

import java.util.List;

/**
 * Interface for reading all Item types and
 * item type by Id.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
public interface ItemTypeService {

    List<ItemType> getItemTypes();

    ItemType getItemType(int itemTypeId);
}
