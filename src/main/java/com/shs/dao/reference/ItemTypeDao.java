package com.shs.dao.reference;

import com.shs.entity.ItemType;

import java.util.List;

public interface ItemTypeDao {

    List<ItemType> readItemTypes();

    ItemType readItemType(int itemTypeId);
}
