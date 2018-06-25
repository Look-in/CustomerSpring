package com.shs.utils;

import com.shs.entity.items.Item;
import com.shs.service.reference.AttributeToCompare;

import java.util.Collections;
import java.util.List;

/**
 * Sorting the original collection of items according to the received attribute.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
public class ItemSortUtil {

    private ItemSortUtil() {
    }

    public static void compare(List<Item> item, AttributeToCompare sortBy) {
        switch (sortBy) {
            case PRICE:
                Collections.sort(item, (o1, o2) -> (o1.getPrice() - o2.getPrice()));
                break;
            case PRICEDESC:
                Collections.sort(item, (o1, o2) -> (o2.getPrice() - o1.getPrice()));
                break;
            case NAME:
                Collections.sort(item, (o1, o2) -> (o1.getName().compareToIgnoreCase(o2.getName())));
                break;
            case STATUS:
                Collections.sort(item, (o1, o2) -> (o1.getItemStatus().getId() - o2.getItemStatus().getId()));
                break;
        }
    }
}
