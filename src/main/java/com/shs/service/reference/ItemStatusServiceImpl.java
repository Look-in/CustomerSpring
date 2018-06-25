package com.shs.service.reference;

import com.shs.dao.reference.ItemStatusDao;
import com.shs.entity.reference.ItemStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemStatusServiceImpl implements ItemStatusService {

    private final ItemStatusDao itemStatusDao;

    @Autowired
    public ItemStatusServiceImpl(ItemStatusDao itemStatusDao) {
        this.itemStatusDao = itemStatusDao;
    }

    @Override
    public List<ItemStatus> readItemStatuses() {
        return itemStatusDao.readItemStatuses();
    }

    @Override
    public ItemStatus readItemStatus(int itemStatusId) {
        return itemStatusDao.read(itemStatusId);
    }
}
