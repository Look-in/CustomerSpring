package com.shs.service.entity;

import com.shs.dao.supply.ReadItem;
import com.shs.dao.supply.ReadListItems;
import com.shs.entity.items.Bicycle;
import com.shs.entity.items.Clothes;
import com.shs.entity.items.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyServiceImpl implements SupplyService {

    @Autowired
    @Qualifier("ItemDao")
    private ReadListItems readItems;

    @Autowired
    @Qualifier("ClothesDao")
    private ReadItem readClothes;

    @Autowired
    @Qualifier("BicycleDao")
    private ReadItem readBicycle;

    @Autowired
    @Qualifier("ItemDao")
    private ReadItem readItem;


    @Override
    public List<Item> getItems(int itemType) {
        return readItems.readListItem(itemType);
    }

    @Override
    public Item getItemAttributes(int itemId, Class itemClass) {
        if (itemClass == Clothes.class) {
            return readClothes.readItem(itemId);
        }
        if (itemClass == Bicycle.class) {
            return readBicycle.readItem(itemId);
        }
        return readItem.readItem(itemId);
    }

}
