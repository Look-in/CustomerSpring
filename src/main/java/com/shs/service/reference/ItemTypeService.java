package com.shs.service.reference;

import com.shs.entity.reference.ItemType;

import java.util.List;

public interface ItemTypeService {

    List<ItemType> getItemTypes();

    ItemType getItemType(int itemTypeId);
}
