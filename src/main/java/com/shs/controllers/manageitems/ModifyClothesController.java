/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * This controller both operates the clothes item and
 * displays the attributes of the clothes for updating or adding
 */
package com.shs.controllers.manageitems;

import com.shs.entity.items.Clothes;
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

@Controller
@RequestMapping("/modify-clothes")
public class ModifyClothesController {

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
    public Clothes newRequest(@RequestParam(required = false) Integer itemId,
                              @RequestParam(required = false) Integer itemTypeId,
                              @RequestParam(required = false) String type) {
        return (itemId != null ? (Clothes) supplyService.getItemAttributes(itemId, Clothes.class) :
                new Clothes(new ItemType(itemTypeId,type)));
    }

    @ModelAttribute(value = "statuses")
    public List<ItemStatus> newRequest() {
        return itemStatus.readItemStatuses();
    }

    @RequestMapping(method = RequestMethod.GET)
    public void doGet() { }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(Clothes item, RedirectAttributes redirectAttributes) {
        pushItem.pushItem(item);
        redirectAttributes.addAttribute("itemTypeId", item.getItemType().getItemTypeId());
        redirectAttributes.addAttribute("type", item.getItemType().getType());
        redirectAttributes.addAttribute("requestKey", "Clothes saved successfully");
        return "redirect:/view-items";
    }
}
