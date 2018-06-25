package com.shs.controllers.manageitems;

import com.shs.entity.items.Item;
import com.shs.entity.reference.ItemStatus;
import com.shs.entity.reference.ItemType;
import com.shs.service.reference.ItemStatusService;
import com.shs.service.entity.PushItem;
import com.shs.service.entity.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * This controller both operates the default items item and
 * displays the attributes of the item for updating or adding.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@Controller
@RequestMapping("/modify-item")
@SessionAttributes("item")
public class ModifyItemController {

    private final SupplyService supplyService;

    private final ItemStatusService itemStatus;

    private final PushItem pushItem;

    @Autowired
    public ModifyItemController(SupplyService supplyService, ItemStatusService itemStatus, PushItem pushItem) {
        this.supplyService = supplyService;
        this.itemStatus = itemStatus;
        this.pushItem = pushItem;
    }

    /**
     * For every request for this controller, this will
     * create a Item instance.
     */
    @ModelAttribute(value = "item")
    public Item newRequest(@RequestParam(required = false) Integer itemId,
                           @RequestParam(required = false) Integer itemTypeId,
                           @RequestParam(required = false) String type) {
        return (itemId != null ? supplyService.getItemAttributes(itemId, Item.class) :
                new Item(new ItemType(itemTypeId, type)));
    }


    @ModelAttribute(value = "statuses")
    public List<ItemStatus> newRequest() {
        return itemStatus.readItemStatuses();
    }

    @RequestMapping(method = RequestMethod.GET)
    public void doGet() {
    }

    @RequestMapping(method = RequestMethod.POST)

    public String doPost(Item item, RedirectAttributes redirectAttributes, SessionStatus sessionStatus) {
        pushItem.pushItem(item);
        redirectAttributes.addAttribute("itemTypeId", item.getItemType().getId());
        redirectAttributes.addAttribute("type", item.getItemType().getType());
        redirectAttributes.addAttribute("requestKey", "Item saved successfully");
        sessionStatus.setComplete();
        return "redirect:/view-items";
    }
}
