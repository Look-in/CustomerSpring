package com.shs.service.entity;

import com.shs.dao.supply.ChangeItem;
import com.shs.entity.items.Bicycle;
import com.shs.entity.items.Clothes;
import com.shs.entity.items.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PushItemImpl implements PushItem {

    @Autowired
    @Qualifier("ClothesDao")
    private ChangeItem pushClothes;

    @Autowired
    @Qualifier("BicycleDao")
    private ChangeItem pushBicycle;

    @Autowired
    @Qualifier("ItemDao")
    private ChangeItem pushDefaultItem;

    @Override
    public void pushItem(Item item) {
        ChangeItem push;
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
                //delete after debugging
              //  item.setPrice(-1);
                //push.update(item);
                //to here
            }
        }

        @Override
        public void deleteItem (int itemId){
        pushDefaultItem.delete(itemId);
        }
    }
