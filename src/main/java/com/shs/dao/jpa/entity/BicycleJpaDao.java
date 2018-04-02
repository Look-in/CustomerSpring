package com.shs.dao.jpa.entity;

import com.shs.dao.jpa.BaseJpaDao;
import com.shs.dao.supply.ReadItem;
import com.shs.entity.Bicycle;
import org.springframework.stereotype.Repository;

@Repository("BicycleDao")
public class BicycleJpaDao extends BaseJpaDao implements ReadItem {

    @Override
    public Bicycle readItem(int itemId) {
        return getEntityManager().find(Bicycle.class, itemId);
    }
}
