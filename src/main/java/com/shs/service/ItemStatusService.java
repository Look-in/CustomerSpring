package com.shs.service;

import com.shs.entity.ItemStatus;

import java.util.List;

public interface ItemStatusService {

    List<ItemStatus> readItemStatuses();

    ItemStatus readItemStatus(int itemStatusId);
}
