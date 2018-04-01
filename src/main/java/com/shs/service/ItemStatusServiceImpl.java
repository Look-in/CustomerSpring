package com.shs.service;

import com.shs.dao.reference.ItemStatusDao;
import com.shs.entity.ItemStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemStatusServiceImpl implements ItemStatusService {

    @Autowired
    private ItemStatusDao itemStatusDao;

    @Override
    public List<ItemStatus> readItemStatuses() {
        return itemStatusDao.readItemStatuses();
    }

    @Override
    public ItemStatus readItemStatus(int itemStatusId) {
        return itemStatusDao.readItemStatus(itemStatusId);
    }
}
