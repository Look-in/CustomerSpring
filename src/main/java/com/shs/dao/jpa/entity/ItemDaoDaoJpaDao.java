/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * DAO that operates with default items
 */
package com.shs.dao.jpa.entity;

import com.shs.dao.jpa.BaseJpaDao;
import com.shs.dao.supply.ChangeItemDao;
import com.shs.dao.supply.ReadItemDao;
import com.shs.dao.supply.ReadListItemsDao;
import com.shs.entity.items.Item;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ItemDao")
public class ItemDaoDaoJpaDao extends BaseJpaDao implements ReadItemDao, ReadListItemsDao, ChangeItemDao<Item> {

    @Override
    public Item readItem(int itemId) {
        getLogger().debug("Start reading entity by key \"{}\"...", itemId);
        Item entity;
        try {
            entity = getEntityManager().find(Item.class, itemId);
        } catch (RuntimeException e) {
            getLogger().error("Error reading entity by key: {}", itemId, e);
            throw new RuntimeException(e);
        }
        getLogger().debug("Entity: \"{}\" read", entity);
        return entity;
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
