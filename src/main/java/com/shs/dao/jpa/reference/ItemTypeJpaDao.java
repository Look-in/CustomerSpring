package com.shs.dao.jpa.reference;

import com.shs.dao.jpa.BaseJpaDao;
import com.shs.dao.reference.ItemTypeDao;
import com.shs.entity.reference.ItemType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemTypeJpaDao extends BaseJpaDao implements ItemTypeDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<ItemType> readItemTypes() {
        return getEntityManager().createQuery("select e from ItemType e").getResultList();
    }

    @Override
    public ItemType readItemType(int itemTypeId) {
        return getEntityManager().find(ItemType.class, itemTypeId);
    }
}
