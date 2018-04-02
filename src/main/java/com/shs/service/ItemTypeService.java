package com.shs.service;

import com.shs.entity.reference.ItemType;

import java.util.List;

public interface ItemTypeService {

    List<ItemType> getItemTypes();

    ItemType getItemType(int itemTypeId);
}
