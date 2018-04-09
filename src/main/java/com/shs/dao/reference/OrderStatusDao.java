/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * Interface for reading all Order statuses and
 * order status by Id
 */
package com.shs.dao.reference;

import com.shs.entity.reference.OrderStatus;

import java.util.List;

public interface OrderStatusDao {

    List<OrderStatus> readOrderStatuses();

    OrderStatus readOrderStatus(int itemStatusId);
}
