package com.shs.controllers.viewitems;

import com.shs.entity.items.Clothes;
import com.shs.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shopping-cart")
public class ShowClothesController {

    @Autowired
    private SupplyService supplyService;

    @ModelAttribute(value = "item")
    public Clothes newRequest(@RequestParam Integer itemId) {
        return (Clothes) supplyService.getItemAttributes(itemId, Clothes.class);
    }

    @RequestMapping(value = "/show-clothes", method = RequestMethod.GET)
    public String doShowClothes() {
        return "modify-clothes";
    }

    @RequestMapping(value = "/show-bicycles", method = RequestMethod.GET)
    public String doShowBicycle() {
        return "modify-bicycles";
    }

    @RequestMapping(value = "/show-item", method = RequestMethod.GET)
    public String doShowItem() {
        return "modify-item";
    }
}
