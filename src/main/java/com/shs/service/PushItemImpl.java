package com.shs.service;

import com.shs.dao.ChangeInstance;
import com.shs.entity.Bicycle;
import com.shs.entity.Clothes;
import com.shs.entity.event.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PushItemImpl implements PushItem {

    @Autowired
    @Qualifier("PushClothes")
    private ChangeInstance pushClothes;

    @Autowired
    @Qualifier("PushBicycle")
    private ChangeInstance pushBicycle;

    @Autowired
    @Qualifier("PushDefaultItem")
    private ChangeInstance pushDefaultItem;

    @Override
    public void pushItem(Item item) {
        ChangeInstance push=null;
        if (item instanceof Bicycle) {
            push = pushBicycle;
        } else {
            if (item instanceof Clothes) {
                push = pushClothes;
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
