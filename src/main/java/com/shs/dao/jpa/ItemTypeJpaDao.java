package com.shs.dao.jpa;

import com.shs.dao.reference.ItemTypeDao;
import com.shs.entity.ItemType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


public class ItemTypeJpaDao implements ItemTypeDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ItemType> readItemTypes() {
        //ItemType.ALL_INVOICE_QUERY
        Query query = getEntityManager().createNamedQuery("SELECT e FROM ITEM_TYPE e");
        return query.getResultList();
    }

    @Override
    public ItemType readItemType(int itemTypeId) {
        Query query = getEntityManager().createNamedQuery("SELECT e FROM ITEM_TYPE e WHERE e.id = :id")
                .setParameter("id", itemTypeId);
        return (ItemType) query.getSingleResult();
    }
}
