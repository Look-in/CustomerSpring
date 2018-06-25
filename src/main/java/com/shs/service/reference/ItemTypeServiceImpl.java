package com.shs.service.reference;

import com.shs.dao.reference.ItemTypeDao;
import com.shs.entity.reference.ItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemTypeServiceImpl implements ItemTypeService {

    private final ItemTypeDao itemTypeDao;

    @Autowired
    public ItemTypeServiceImpl(ItemTypeDao itemTypeDao) {
        this.itemTypeDao = itemTypeDao;
    }

    @Override
    public List<ItemType> getItemTypes() {
        return itemTypeDao.readItemTypes();
    }

    @Override
    public ItemType getItemType(int itemTypeId) {
        return itemTypeDao.read(itemTypeId);
    }
}
