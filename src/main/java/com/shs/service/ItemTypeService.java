package com.shs.service;

import com.shs.entity.ItemStatus;
import com.shs.entity.ItemType;

import java.util.List;

public interface ItemTypeService {

    List<ItemType> getItemTypes();

    ItemType getItemType(int itemTypeId);

    List<ItemStatus> readItemStatuses();

    ItemStatus readItemStatus(int itemStatusId);
}
