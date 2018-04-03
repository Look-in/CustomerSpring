package com.shs.dao.jpa.entity;

import com.shs.dao.jpa.BaseJpaDao;
import com.shs.dao.supply.ChangeInstance;
import com.shs.dao.supply.ReadItem;
import com.shs.entity.Clothes;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("ClothesDao")
public class ClothesJpaDao extends BaseJpaDao implements ReadItem, ChangeInstance<Clothes> {

    @Override
    public Clothes readItem(int itemId) {
        return getEntityManager().find(Clothes.class, itemId);
    }

    @Override
    @Transactional
    public void create(Clothes entity) {
        getEntityManager().persist(entity);
    }

    @Override
    @Transactional
    public void update(Clothes entity) {
        getEntityManager().merge(entity);
        getEntityManager().flush();
    }

    @Override
    @Transactional
    public void delete(int id) {
        Clothes entity = readItem(id);
        getEntityManager().remove(entity);
        getEntityManager().flush();
    }
}
