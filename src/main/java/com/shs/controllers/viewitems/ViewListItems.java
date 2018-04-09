/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * This controller displays all items in the shop
 */
package com.shs.controllers.viewitems;

import com.shs.service.shoppingcart.ShoppingCart;
import com.shs.entity.reference.ItemType;
import com.shs.service.comparator.ItemComparator;
import com.shs.service.comparator.AttributeToCompare;
import com.shs.entity.items.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.shs.service.reference.ItemTypeService;
import com.shs.service.entity.SupplyService;

import java.util.List;

@Controller
@RequestMapping("/view-items")
public class ViewListItems {

    @Autowired
    private SupplyService supplyService;

    @Autowired
    private ItemTypeService itemType;

    @ModelAttribute(value = "item")
    public List<Item> newRequest(@RequestParam(required = false, defaultValue = "0") int itemTypeId,
                                 @RequestParam(required = false) AttributeToCompare sortingBy) {
        List<Item> items = supplyService.getItems(itemTypeId);
        if (sortingBy != null) {
            ItemComparator.compare(items, sortingBy);
        }
        return items;
    }

    //transfer the number of items in the cart
    @ModelAttribute(value = "countBasketItem")
    public Integer hasBasket() {
        return (ShoppingCart.shoppingCart.get(SecurityContextHolder.getContext().getAuthentication().getName()) != null ?
                ShoppingCart.shoppingCart.get(SecurityContextHolder.getContext().getAuthentication().getName()).getItems().size() :
                null);
    }

    @ModelAttribute(value = "itemTypes")
    public List<ItemType> newRequest() {
        return itemType.getItemTypes();
    }

    @ModelAttribute(value = "sortBy")
    public AttributeToCompare[] newRequestAttr() {
        return AttributeToCompare.values();
    }

    @RequestMapping(method = RequestMethod.GET)
    public void doGet() {
    }

    @RequestMapping(method = RequestMethod.POST)
    public void doPost() {
    }

}
