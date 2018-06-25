package com.shs.dao.jpa.entity;

import com.shs.dao.entity.ItemDao;
import com.shs.dao.jpa.BaseJpaDao;
import com.shs.entity.items.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO that operates with default items.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@Repository("ItemDao")
public class ItemJpaDao extends BaseJpaDao<Integer, Item> implements ItemDao<Item> {

    @Override
    @SuppressWarnings("unchecked")
    public List<Item> readListItem(int itemType) {
        List<Item> items;
        if (itemType == 0) {
            items = getSession().getNamedQuery(Item.ALL_ITEM_QUERY).list();
        } else {
            items = getSession().getNamedQuery(Item.ITEM_QUERY)
                    .setParameter("id", itemType).list();
        }
        return items;
    }
}
