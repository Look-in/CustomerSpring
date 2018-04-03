package com.shs.dao.jpa.entity;

import com.shs.dao.jpa.BaseJpaDao;
import com.shs.dao.supply.ChangeInstance;
import com.shs.dao.supply.ReadItem;
import com.shs.entity.Bicycle;
import org.springframework.stereotype.Repository;

@Repository("BicycleDao")
public class BicycleJpaDao extends BaseJpaDao implements ReadItem, ChangeInstance<Bicycle> {

    @Override
    public Bicycle readItem(int itemId) {
        return getEntityManager().find(Bicycle.class, itemId);
    }

    @Override
    public void create(Bicycle entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public void update(Bicycle entity) {
        getEntityManager().merge(entity);
        getEntityManager().flush();
    }

    @Override
    public void delete(int id) {
        Bicycle entity = readItem(id);
        getEntityManager().remove(entity);
        getEntityManager().flush();
    }
}
