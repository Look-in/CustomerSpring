package com.shs.dao.jpa.reference;

import com.shs.dao.jpa.BaseJpaDao;
import com.shs.dao.reference.ItemStatusDao;
import com.shs.entity.reference.ItemStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemStatusJpaDao extends BaseJpaDao implements ItemStatusDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<ItemStatus> readItemStatuses() {
        return getEntityManager().createQuery("select e from ItemStatus e").getResultList();
    }

    @Override
    public ItemStatus readItemStatus(int itemStatusId) {
        return getEntityManager().find(ItemStatus.class, itemStatusId);
    }
}
