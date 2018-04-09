package com.shs.dao.jpa;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Base class with Entity manager and Logger for all DaoClasses.
 *
 * @author Serg Shankunas
 */
public abstract class BaseJpaDao {

    @Getter
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    @Getter
    @Setter
    private EntityManager entityManager;
}
