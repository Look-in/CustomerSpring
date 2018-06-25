package com.shs.dao.reference;

import com.shs.dao.supply.CrudDao;
import com.shs.entity.reference.OrderStatus;

/**
 * Interface for reading all Item statuses and
 * item status by Id.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
public interface OrderStatusDao extends CrudDao<Integer, OrderStatus> {
}
