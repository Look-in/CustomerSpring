package com.shs.service.entity;

import com.shs.entity.items.Item;

/**
 * <code>Service</code> For change items.
 *
 * @author Serg Shankunas
 */
public interface PushItem {

    void pushItem(Item item);

    void deleteItem(int itemId);
}
