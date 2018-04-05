package com.shs.controllers.manageitems;

import com.shs.entity.items.Bicycle;
import com.shs.entity.reference.ItemStatus;
import com.shs.entity.reference.ItemType;
import com.shs.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        new Bicycle(new ItemType(itemTypeId,type)));
    }

    @ModelAttribute(value = "statuses")
    public List<ItemStatus> newRequest() {
        return itemStatus.readItemStatuses();
    }

    @RequestMapping(method = RequestMethod.GET)
    public void doGet() { }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(Bicycle bicycle,RedirectAttributes redirectAttributes) {
        pushItem.pushItem(bicycle);
        redirectAttributes.addAttribute("itemTypeId", bicycle.getItemType().getItemTypeId());
        redirectAttributes.addAttribute("type", bicycle.getItemType().getType());
        redirectAttributes.addAttribute("requestKey", "Bicycle saved successfully");
        return "redirect:/view-items";
    }
}


