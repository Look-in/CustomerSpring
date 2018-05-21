package com.shs.controllers.viewitems;

import com.shs.service.shoppingcart.ShoppingCart;
import com.shs.entity.reference.ItemType;
import com.shs.utils.ItemSortUtil;
import com.shs.service.reference.AttributeToCompare;
import com.shs.entity.items.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.shs.service.reference.ItemTypeService;
import com.shs.service.entity.SupplyService;

import java.util.List;
import java.util.Objects;

/**
 * This controller displays all items in the shop.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@Controller
@RequestMapping("/view-items")
public class ViewListItems {

    private SupplyService supplyService;

    private ItemTypeService itemType;

    @Autowired
    public ViewListItems(SupplyService supplyService, ItemTypeService itemType) {
        Objects.requireNonNull(supplyService, "SupplyService must not be null!");
        Objects.requireNonNull(itemType, "ItemTypeService must not be null!");
        this.itemType = itemType;
        this.supplyService = supplyService;
    }

    @ModelAttribute(value = "item")
    public List<Item> newRequest(@RequestParam(required = false, defaultValue = "0") int itemTypeId,
                                 @RequestParam(required = false) AttributeToCompare sortingBy) {
        List<Item> items = supplyService.getItems(itemTypeId);
        if (sortingBy != null) {
            ItemSortUtil.compare(items, sortingBy);
        }
        return items;
    }

    /**
     * Transfer the number of items in the cart.
     *
     * @return Integer - null or count items
     */
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
