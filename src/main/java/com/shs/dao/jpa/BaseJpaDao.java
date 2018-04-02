/**
 * Base class for all DaoClasses.
 * @author Serg Shankunas
 */
package com.shs.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseJpaDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
