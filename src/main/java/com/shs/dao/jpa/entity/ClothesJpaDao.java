package com.shs.dao.jpa.entity;

import com.shs.dao.entity.ItemDao;
import com.shs.dao.jpa.BaseJpaDao;
import com.shs.entity.items.Clothes;
import com.shs.entity.items.Item;
import com.shs.entity.orders.Order;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO that operates with Clothes.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@Repository("ClothesDao")
public class ClothesJpaDao extends BaseJpaDao<Integer, Clothes> implements ItemDao<Clothes> {

    @Override
    @SuppressWarnings("unchecked")
    public List<Clothes> readListItem(int itemType) {
        List<Clothes> items;
        if (itemType == 0) {
            items = getSession().getNamedQuery(Item.ALL_ITEM_QUERY).list();
        } else {
            items = getSession().getNamedQuery(Item.ITEM_QUERY)
                    .setParameter("id", itemType).list();
        }
        return items;
    }

    @Override
    public void create(Clothes item) {
        Session session = getSession();
        Order order = session.load(Order.class, 4L);
        item.setOrder(order);
        session.save(item);
    }

    @Override
    public void update(Clothes item) {
        Session session = getSession();
        //Order order = session.load(Order.class, 4L);
        Order order = new Order();
        order.setId(4);
        item.setOrder(order);
        item.setId(null);
        session.save(item);
    }
}
