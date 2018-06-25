package com.shs.dao.jpa.reference;

import com.shs.dao.jpa.BaseJpaDao;
import com.shs.dao.reference.ItemTypeDao;
import com.shs.entity.reference.ItemType;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * DAO for reading item types.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@Repository
public class ItemTypeJpaDao extends BaseJpaDao<Integer, ItemType> implements ItemTypeDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<ItemType> readItemTypes() {
        return getSession().createQuery("select e from ItemType e").list();
    }
}
