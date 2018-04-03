package com.shs.service;

import com.shs.dao.supply.ChangeInstance;
import com.shs.entity.Bicycle;
import com.shs.entity.Clothes;
import com.shs.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PushItemImpl implements PushItem {

    @Autowired
    @Qualifier("ClothesDao")
    private ChangeInstance pushClothes;

    @Autowired
    @Qualifier("BicycleDao")
    private ChangeInstance pushBicycle;

    @Autowired
    @Qualifier("ItemDao")
    private ChangeInstance pushDefaultItem;

    @Override
    public void pushItem(Item item) {
        ChangeInstance push;
        if (item instanceof Bicycle) {
            push = pushBicycle;
        } else {
            if (item instanceof Clothes) {
                push = pushClothes;
            } else {
                push=pushDefaultItem;
            }
        }
            if (item.getItemId() == 0) {
                push.create(item);
            }
            else {
                push.update(item);
            }
        }

        @Override
        public void deleteItem (int itemId){
        pushDefaultItem.delete(itemId);
        }
    }
