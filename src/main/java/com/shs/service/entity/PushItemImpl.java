/**
 * <code>Service</code> Implements methods for changing items<br>
 * @author Serg Shankunas
 */
package com.shs.service.entity;

import com.shs.dao.supply.ChangeItemDao;
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
    private ChangeItemDao pushClothes;

    @Autowired
    @Qualifier("BicycleDao")
    private ChangeItemDao pushBicycle;

    @Autowired
    @Qualifier("ItemDao")
    private ChangeItemDao pushDefaultItem;

    /**
     * Factory method for changing Item by ItemClass
     */
    @Override
    public void pushItem(Item item) {
        ChangeItemDao push;
        if (item instanceof Bicycle) {
            push = pushBicycle;
        } else {
            if (item instanceof Clothes) {
                push = pushClothes;
            } else {
                push = pushDefaultItem;
            }
        }
            if (item.getItemId() == null) {
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
