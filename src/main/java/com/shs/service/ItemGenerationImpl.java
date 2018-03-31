package com.shs.service;

import com.shs.entity.Bicycle;
import com.shs.entity.Clothes;
import com.shs.entity.event.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemGenerationImpl implements ItemGeneration {

    @Autowired
    private ItemTypeService itemTypeService;

    @Override
    public Clothes getNewClothes() {
        Clothes clothes = new Clothes();
        setDefaultItemAttributes(clothes);
        return clothes;
    }

    @Override
    public Bicycle getNewBicycle() {
        Bicycle bicycle = new Bicycle();
        setDefaultItemAttributes(bicycle);
        return bicycle;
    }

    @Override
    public Item getNewItem() {
        Item item = new Item();
        setDefaultItemAttributes(item);
        return item;
    }

    private void setDefaultItemAttributes(Item item) {
        item.setItemStatus(itemTypeService.readItemStatus(1));
        int itemType=1;
        if (item instanceof Clothes) {
            itemType=1;
        } else {
            if (item instanceof Bicycle) {
                itemType=2;
            }
        }
        item.setItemType(itemTypeService.getItemType(itemType));
    }
}

