package com.shs.controllers;

import com.shs.entity.Clothes;
import com.shs.entity.ItemStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.shs.service.ItemGeneration;
import com.shs.service.ItemTypeService;
import com.shs.service.PushItem;
import com.shs.service.SupplyService;

import java.util.List;

@Controller
@RequestMapping("/viewclothesmodify")
public class ViewClothesModify {

    @Autowired
    private SupplyService supplyService;

    @Autowired
    private ItemTypeService itemType;

    @Autowired
    private PushItem pushItem;

    @Autowired
    private ItemGeneration itemGeneration;

    /**
     * For every request for this controller, this will
     * create a Item instance
     * */
    @ModelAttribute(value = "item")
    public Clothes newRequest(@RequestParam(required = false) Integer itemId) {
        return (itemId != null ? (Clothes) supplyService.getItemAttributes(itemId, Clothes.class) :
                itemGeneration.getNewClothes());
    }

    @ModelAttribute(value = "statuses")
    public List<ItemStatus> newRequest() {
        return itemType.readItemStatuses();
    }

    @RequestMapping(method = RequestMethod.GET)
    public void doGet() { }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(Clothes clothes, RedirectAttributes redirectAttributes) {
        pushItem.pushItem(clothes);
        redirectAttributes.addAttribute("itemTypeId", clothes.getItemType().getItemTypeId());
        redirectAttributes.addAttribute("requestKey", "Clothes saved successfully");
        return "redirect:/view-item";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String doDelete(@RequestParam Integer itemId, @RequestParam int itemTypeId, RedirectAttributes redirectAttributes) {
        pushItem.deleteItem(itemId);
        redirectAttributes.addAttribute("itemTypeId", itemTypeId);
        redirectAttributes.addAttribute("requestKey", "Clothes deleted successfully");
        return "redirect:/view-item";
    }
}
