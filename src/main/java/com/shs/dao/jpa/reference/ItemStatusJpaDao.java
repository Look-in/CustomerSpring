package com.shs.dao.jpa.reference;

import com.shs.dao.jpa.BaseJpaDao;
import com.shs.dao.reference.ItemStatusDao;
import com.shs.entity.reference.ItemStatus;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * DAO for reading item statuses
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@Repository
public class ItemStatusJpaDao extends BaseJpaDao<Integer, ItemStatus> implements ItemStatusDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<ItemStatus> readItemStatuses() {
        return getSession().createQuery("select e from ItemStatus e").list();
    }
}
