package com.shs.controllers;

import com.shs.entity.Item;
import com.shs.entity.reference.ItemStatus;
import com.shs.entity.reference.ItemType;
import com.shs.service.ItemStatusService;
import com.shs.service.PushItem;
import com.shs.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/view-item-modify")
public class ModifyItemController {

    @Autowired
    private SupplyService supplyService;

    @Autowired
    private ItemStatusService itemStatus;

    @Autowired
    private PushItem pushItem;

    /**
     * For every request for this controller, this will
     * create a Item instance
     * */
    @ModelAttribute(value = "item")
    public Item newRequest(@RequestParam(required = false) Integer itemId,
                              @RequestParam(required = false) Integer itemTypeId,
                              @RequestParam(required = false) String type) {
        return (itemId != null ? supplyService.getItemAttributes(itemId, Item.class) :
                new Item(new ItemType(itemTypeId,type)));
    }

    @ModelAttribute(value = "statuses")
    public List<ItemStatus> newRequest() {
        return itemStatus.readItemStatuses();
    }

    @RequestMapping(method = RequestMethod.GET)
    public void doGet() { }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(Item item, RedirectAttributes redirectAttributes) {
        pushItem.pushItem(item);
        redirectAttributes.addAttribute("itemTypeId", item.getItemType().getItemTypeId());
        redirectAttributes.addAttribute("type", item.getItemType().getType());
        redirectAttributes.addAttribute("requestKey", "Item saved successfully");
        return "redirect:/view-item";
    }
}
