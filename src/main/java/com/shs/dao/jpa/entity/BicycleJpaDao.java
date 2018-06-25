package com.shs.dao.jpa.entity;

import com.shs.dao.entity.ItemDao;
import com.shs.dao.jpa.BaseJpaDao;
import com.shs.entity.items.Bicycle;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO that operates with Bicycles.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@Repository("BicycleDao")
public class BicycleJpaDao extends BaseJpaDao<Integer, Bicycle> implements ItemDao<Bicycle> {

    @Override
    @SuppressWarnings("unchecked")
    public List<Bicycle> readListItem(int itemType) {
        List<Bicycle> items;
        if (itemType == 0) {
            items = getSession().getNamedQuery(Bicycle.ALL_ITEM_QUERY).list();
        } else {
            items = getSession().getNamedQuery(Bicycle.ITEM_QUERY)
                    .setParameter("id", itemType).list();
        }
        return items;
    }
}
