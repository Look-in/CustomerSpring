package com.shs.dao.jpa.reference;

import com.shs.dao.jpa.BaseJpaDao;
import com.shs.dao.reference.OrderStatusDao;
import com.shs.entity.reference.OrderStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO for reading order statuses.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@Repository
public class OrderStatusJpaDao extends BaseJpaDao implements OrderStatusDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<OrderStatus> readOrderStatuses() {
        return getEntityManager().createQuery("select e from OrderStatus e").getResultList();
    }

    @Override
    public OrderStatus readOrderStatus(int itemStatusId) {
        return getEntityManager().find(OrderStatus.class, itemStatusId);
    }
}
