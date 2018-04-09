/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * DAO for reading order statuses
 */
package com.shs.dao.jpa.reference;

import com.shs.dao.jpa.BaseJpaDao;
import com.shs.dao.reference.OrderStatusDao;
import com.shs.entity.reference.OrderStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderStatusJpaDao extends BaseJpaDao implements OrderStatusDao {

    @Override
    public List<OrderStatus> readOrderStatuses() {
        return getEntityManager().createQuery("select e from OrderStatus e").getResultList();
    }

    @Override
    public OrderStatus readOrderStatus(int itemStatusId) {
        return getEntityManager().find(OrderStatus.class, itemStatusId);
    }
}
