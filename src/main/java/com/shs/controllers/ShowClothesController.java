package com.shs.controllers;

import com.shs.entity.Clothes;
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
@RequestMapping("/show-clothes")
public class ShowClothesController {

    @Autowired
    private SupplyService supplyService;

    @ModelAttribute(value = "item")
    public Clothes newRequest(@RequestParam Integer itemId) {
        return (Clothes) supplyService.getItemAttributes(itemId, Clothes.class);
    }

    @RequestMapping(method = RequestMethod.GET)
    public void doGet() { }

/*    @RequestMapping(method = RequestMethod.POST)
    public String doPost(Clothes clothes, RedirectAttributes redirectAttributes) {
        pushItem.pushItem(clothes);
        redirectAttributes.addAttribute("itemTypeId", clothes.getItemType().getItemTypeId());
        redirectAttributes.addAttribute("type", clothes.getItemType().getType());
        redirectAttributes.addAttribute("requestKey", "Clothes saved successfully");
        return "redirect:/view-items";
    }*/
}
