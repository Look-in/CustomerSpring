package com.shs.service.entity;

import com.shs.dao.entity.ItemDao;
import com.shs.dao.jpa.entity.ClothesJpaDao;
import com.shs.dao.supply.CrudDao;
import com.shs.entity.items.Bicycle;
import com.shs.entity.items.Clothes;
import com.shs.entity.items.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <code>Service</code> Implements methods for changing items.
 *
 * @author Serg Shankunas
 */
@Service
public class PushItemImpl implements PushItem {

    private final ItemDao pushClothes;

    private final ItemDao pushBicycle;

    private final ItemDao pushDefaultItem;

    @Autowired
    public PushItemImpl(@Qualifier("ClothesDao") ItemDao pushClothes, @Qualifier("BicycleDao") ItemDao pushBicycle, @Qualifier("ItemDao") ItemDao pushDefaultItem) {
        this.pushClothes = pushClothes;
        this.pushBicycle = pushBicycle;
        this.pushDefaultItem = pushDefaultItem;
    }

    /**
     * Factory method for changing Item by ItemClass
     */
    @Override
    @SuppressWarnings("unchecked")
    public void pushItem(Item item) {
        CrudDao push;
        if (item instanceof Bicycle) {
            push = pushBicycle;
        } else {
            if (item instanceof Clothes) {
                push = pushClothes;
            } else {
                push = pushDefaultItem;
            }
        }
        if (item.getId() == null) {
            push.create(item);
        } else {
            push.update(item);
        }
    }

    @Override
    public void deleteItem(int itemId) {
        pushDefaultItem.delete(itemId);
    }
}
