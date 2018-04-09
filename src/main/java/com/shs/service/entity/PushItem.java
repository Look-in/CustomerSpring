/**
 * <code>Service</code> For change items<br>
 * @author Serg Shankunas
 */
package com.shs.service.entity;

import com.shs.entity.items.Item;

public interface PushItem {

    void pushItem(Item item);

    void deleteItem(int itemId);
}
