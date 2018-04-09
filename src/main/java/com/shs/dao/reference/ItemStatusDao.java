/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * Interface for reading all Item statuses and
 * item status by Id
 */
package com.shs.dao.reference;

import com.shs.entity.reference.ItemStatus;

import java.util.List;

public interface ItemStatusDao {

    List<ItemStatus> readItemStatuses();

    ItemStatus readItemStatus(int itemStatusId);
}
