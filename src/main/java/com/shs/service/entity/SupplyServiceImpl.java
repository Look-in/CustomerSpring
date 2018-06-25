package com.shs.service.entity;

import com.shs.dao.entity.ItemDao;
import com.shs.entity.items.Bicycle;
import com.shs.entity.items.Clothes;
import com.shs.entity.items.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implements service for reading item attributes and List of items by type.
 *
 * @author Serg Shankunas
 */
@Service
@Transactional
public class SupplyServiceImpl implements SupplyService {

    private final ItemDao readClothes;

    private final ItemDao readBicycle;

    private final ItemDao readItemDao;

    @Autowired
    public SupplyServiceImpl(@Qualifier("ClothesDao") ItemDao readClothes, @Qualifier("BicycleDao") ItemDao readBicycle, @Qualifier("ItemDao") ItemDao readItemDao) {
        this.readClothes = readClothes;
        this.readBicycle = readBicycle;
        this.readItemDao = readItemDao;
    }


    @Override
    public List<Item> getItems(int itemType) {
        return readItemDao.readListItem(itemType);
    }

    @Override
    public Item getItemAttributes(int itemId, Class itemClass) {
        if (itemClass == Clothes.class) {
            return (Clothes) readClothes.read(itemId);
        }
        if (itemClass == Bicycle.class) {
            return (Bicycle) readBicycle.read(itemId);
        }
        return (Item) readItemDao.read(itemId);
    }

}
