package com.shs.service;

import com.shs.dao.supply.ReadItem;
import com.shs.dao.supply.ReadListItems;
import com.shs.entity.Bicycle;
import com.shs.entity.Clothes;
import com.shs.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplyServiceImpl implements SupplyService {

    @Autowired
    @Qualifier("ReadDefaultItem")
    private ReadListItems readItems;

    @Autowired
    @Qualifier("ReadClothes")
    private ReadItem readClothes;

    @Autowired
    @Qualifier("ReadBicycle")
    private ReadItem readBicycle;

    @Autowired
    @Qualifier("ReadDefaultItem")
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
        return null;
    }

}
