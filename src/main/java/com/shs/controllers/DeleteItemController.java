package com.shs.controllers;

import com.shs.entity.Bicycle;
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
@RequestMapping("/delete")
public class DeleteItemController {

    @Autowired
    private PushItem pushItem;

    @RequestMapping(method=RequestMethod.POST)
    public String doDelete(@RequestParam Integer itemId,
                           @RequestParam Integer itemTypeId,
                           @RequestParam String type,
                           RedirectAttributes redirectAttributes) {
        pushItem.deleteItem(itemId);
        redirectAttributes.addAttribute("itemTypeId", itemTypeId);
        redirectAttributes.addAttribute("type", type);
        redirectAttributes.addAttribute("requestKey", "Item deleted successfully");
        return "redirect:/view-item";
    }
}


