package com.shs.service;

import com.shs.entity.event.Item;

import java.util.List;

public interface SupplyService {

    List<Item> getItems(int itemType);

    Item getItemAttributes(int itemId, Class itemType);
}