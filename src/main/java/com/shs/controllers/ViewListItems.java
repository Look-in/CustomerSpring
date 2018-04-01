package com.shs.controllers;

import com.shs.entity.ItemType;
import com.shs.entity.comparator.ItemComparator;
import com.shs.entity.event.AttributeToCompare;
import com.shs.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.shs.service.ItemTypeService;
import com.shs.service.SupplyService;

import java.util.List;

@Controller
@RequestMapping("/view-item")
public class ViewListItems {

    @Autowired
    private SupplyService supplyService;

    @Autowired
    private ItemTypeService itemType;

    @ModelAttribute(value = "item")
    public List<Item> newRequest(@RequestParam(required=false, defaultValue = "0") int itemTypeId,
                                 @RequestParam(required=false) AttributeToCompare sortingBy) {
        List<Item> items = supplyService.getItems(itemTypeId);
        if (sortingBy != null) {
            ItemComparator.compare(items, sortingBy);
        }
        return items;
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
