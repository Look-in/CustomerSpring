package com.shs.dao.jpa.entity;

import com.shs.dao.jpa.BaseJpaDao;
import com.shs.dao.supply.ReadItem;
import com.shs.entity.Bicycle;
import com.shs.entity.Clothes;
import org.springframework.stereotype.Repository;

@Repository("ClothesDao")
public class ClothesJpaDao extends BaseJpaDao implements ReadItem {

    @Override
    public Clothes readItem(int itemId) {
        return getEntityManager().find(Clothes.class, itemId);
    }

}
