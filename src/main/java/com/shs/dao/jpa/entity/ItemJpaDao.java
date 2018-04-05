package com.shs.dao.jpa.entity;

import com.shs.dao.jpa.BaseJpaDao;
import com.shs.dao.supply.ChangeItem;
import com.shs.dao.supply.ReadItem;
import com.shs.dao.supply.ReadListItems;
import com.shs.entity.items.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ItemDao")
public class ItemJpaDao extends BaseJpaDao implements ReadItem, ReadListItems, ChangeItem<Item> {

    @Override
    public Item readItem(int itemId) {
        return getEntityManager().find(Item.class, itemId);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Item> readListItem(int itemType) {
        List<Item> items;
        if (itemType == 0) {
            items = getEntityManager().createNamedQuery(Item.ALL_ITEM_QUERY).getResultList();
        } else {
            items = getEntityManager().createNamedQuery(Item.ITEM_QUERY)
                    .setParameter("id", itemType).getResultList();
        }
        return items;
    }

    @Override
    public void create(Item entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public void update(Item entity) {
        getEntityManager().merge(entity);
        getEntityManager().flush();
    }

    @Override
    public void delete(int id) {
        Item entity = readItem(id);
        getEntityManager().remove(entity);
        getEntityManager().flush();
    }
}
