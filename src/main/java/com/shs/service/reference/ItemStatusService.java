package com.shs.service.reference;

import com.shs.entity.reference.ItemStatus;

import java.util.List;

/**
 * Interface for reading all Item statuses and
 * item status by Id.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
public interface ItemStatusService {

    List<ItemStatus> readItemStatuses();

    ItemStatus readItemStatus(int itemStatusId);
}
