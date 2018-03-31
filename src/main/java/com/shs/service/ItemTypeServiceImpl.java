package com.shs.service;

import com.shs.dao.ReadItemTypeDao;
import com.shs.entity.ItemStatus;
import com.shs.entity.ItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemTypeServiceImpl implements ItemTypeService {

    @Autowired
    private ReadItemTypeDao itemTypeDao;

    @Override
    public List<ItemType> getItemTypes() {
        return itemTypeDao.readItemTypes();
    }

    @Override
    public ItemType getItemType(int itemTypeId) {
        return itemTypeDao.readItemType(itemTypeId);
    }

    @Override
    public List<ItemStatus> readItemStatuses() {
        return itemTypeDao.readItemStatuses();
    }

    @Override
    public ItemStatus readItemStatus(int itemStatusId) {
        return itemTypeDao.readItemStatus(itemStatusId);
    }
}
