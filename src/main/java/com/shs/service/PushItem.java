package com.shs.service;

import com.shs.entity.event.Item;

public interface PushItem {

    void pushItem(Item item);

    void deleteItem(int itemId);
}
