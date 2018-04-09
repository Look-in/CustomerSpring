package com.shs.service.entity;

import com.shs.dao.supply.ReadItemDao;
import com.shs.dao.supply.ReadListItemsDao;
import com.shs.entity.items.Bicycle;
import com.shs.entity.items.Clothes;
import com.shs.entity.items.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements service for reading item attributes and List of items by type.
 *
 * @author Serg Shankunas
 */
@Service
public class SupplyServiceImpl implements SupplyService {

    @Autowired
    @Qualifier("ItemDao")
    private ReadListItemsDao readItems;

    @Autowired
    @Qualifier("ClothesDao")
    private ReadItemDao readClothes;

    @Autowired
    @Qualifier("BicycleDao")
    private ReadItemDao readBicycle;

    @Autowired
    @Qualifier("ItemDao")
    private ReadItemDao readItemDao;


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
        return readItemDao.readItem(itemId);
    }

}
