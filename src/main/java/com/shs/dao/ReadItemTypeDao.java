package com.shs.dao;

import com.shs.entity.ItemStatus;
import com.shs.entity.ItemType;

import java.util.List;

public interface ReadItemTypeDao {

    List<ItemType> readItemTypes();

    ItemType readItemType(int itemTypeId);

    List<ItemStatus> readItemStatuses();

    ItemStatus readItemStatus(int itemStatusId);
}
