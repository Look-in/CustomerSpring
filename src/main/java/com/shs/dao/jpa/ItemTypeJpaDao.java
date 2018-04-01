package com.shs.dao.jpa;

import com.shs.dao.reference.ItemTypeDao;
import com.shs.entity.ItemType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
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
        return entityManager.createQuery("select e from ItemType e").getResultList();
    }

    @Override
    public ItemType readItemType(int itemTypeId) {
        return entityManager.find(ItemType.class, itemTypeId);
    }
}
