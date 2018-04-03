package com.shs.service;

import com.shs.entity.Item;

import java.sql.SQLException;

public interface PushItem {

    void pushItem(Item item);

    void deleteItem(int itemId);
}
