/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * DAO that operates with Clothes
 */
package com.shs.dao.jpa.entity;

import com.shs.dao.jpa.BaseJpaDao;
import com.shs.dao.supply.ChangeItemDao;
import com.shs.dao.supply.ReadItemDao;
import com.shs.entity.items.Clothes;
import org.springframework.stereotype.Repository;

@Repository("ClothesDao")
public class ClothesJpaDao extends BaseJpaDao implements ReadItemDao, ChangeItemDao<Clothes> {

    @Override
    public Clothes readItem(int itemId) {
        return getEntityManager().find(Clothes.class, itemId);
    }

    @Override
    public void create(Clothes entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public void update(Clothes entity) {
        getEntityManager().merge(entity);
        getEntityManager().flush();
    }

    @Override
    public void delete(int id) {
        Clothes entity = readItem(id);
        getEntityManager().remove(entity);
        getEntityManager().flush();
    }
}
