package com.shs.dao.jpa.reference;

import com.shs.dao.jpa.BaseJpaDao;
import com.shs.dao.reference.OrderStatusDao;
import com.shs.dao.supply.CrudDao;
import com.shs.entity.reference.OrderStatus;
import org.springframework.stereotype.Repository;

/**
 * DAO for reading order statuses.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@Repository
public class OrderStatusJpaDao extends BaseJpaDao<Integer, OrderStatus> implements OrderStatusDao {

}
