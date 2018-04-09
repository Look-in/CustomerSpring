/**
 * <code>Service</code> For reading List items and Item attributes<br>
 * @author Serg Shankunas
 */
package com.shs.service.entity;

import com.shs.entity.items.Item;

import java.util.List;

public interface SupplyService {

    List<Item> getItems(int itemType);

    Item getItemAttributes(int itemId, Class itemType);
}
