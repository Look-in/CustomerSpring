package com.shs.service;

import com.shs.dao.reference.ItemTypeDao;
import com.shs.entity.reference.ItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemTypeServiceImpl implements ItemTypeService {

    @Autowired
    private ItemTypeDao itemTypeDao;

    @Override
    public List<ItemType> getItemTypes() {
        return itemTypeDao.readItemTypes();
    }

    @Override
    public ItemType getItemType(int itemTypeId) {
        return itemTypeDao.readItemType(itemTypeId);
    }
}
