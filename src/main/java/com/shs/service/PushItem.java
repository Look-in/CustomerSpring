package com.shs.service;

import com.shs.entity.items.Item;

public interface PushItem {

    void pushItem(Item item);

    void deleteItem(int itemId);
}
