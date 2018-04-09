/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * This controller both operates the bicycle item and
 * displays the attributes of the bicycle for updating or adding
 */
package com.shs.controllers.manageitems;

import com.shs.entity.items.Bicycle;
import com.shs.entity.reference.ItemStatus;
import com.shs.entity.reference.ItemType;
import com.shs.service.entity.PushItem;
import com.shs.service.entity.SupplyService;
import com.shs.service.reference.ItemStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/modify-bicycles")
public class ModifyBicycleController {

    @Autowired
    private SupplyService supplyService;

    @Autowired
    private ItemStatusService itemStatus;

    @Autowired
    private PushItem pushItem;

    /**
     * For every request for this controller, this will
     * create a Item instance
     */
    @ModelAttribute(value = "item")
    public Bicycle newRequest(@RequestParam(required = false) Integer itemId,
                              @RequestParam(required = false) Integer itemTypeId,
                              @RequestParam(required = false) String type) {
        return (itemId != null ? (Bicycle) supplyService.getItemAttributes(itemId, Bicycle.class) :
                new Bicycle(new ItemType(itemTypeId, type)));
    }

    @ModelAttribute(value = "statuses")
    public List<ItemStatus> newRequest() {
        return itemStatus.readItemStatuses();
    }

    @RequestMapping(method = RequestMethod.GET)
    public void doGet() {
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(Bicycle item, RedirectAttributes redirectAttributes) {
        pushItem.pushItem(item);
        redirectAttributes.addAttribute("itemTypeId", item.getItemType().getItemTypeId());
        redirectAttributes.addAttribute("type", item.getItemType().getType());
        redirectAttributes.addAttribute("requestKey", "Bicycle saved successfully");
        return "redirect:/view-items";
    }
}


