package com.shs.controllers.viewitems;

import com.shs.entity.items.Bicycle;
import com.shs.entity.items.Clothes;
import com.shs.entity.items.Item;
import com.shs.service.entity.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * This controller displays the attributes of the item.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@Controller
@RequestMapping("/shopping-cart")
public class ShowItemAttributesController {

    @Autowired
    private SupplyService supplyService;

    @RequestMapping(value = "/show-clothes", method = RequestMethod.GET)
    public ModelAndView doShowClothes(@RequestParam Integer itemId) {
        ModelAndView modelAndView = new ModelAndView("modify-clothes");
        modelAndView.addObject("item", supplyService.getItemAttributes(itemId, Clothes.class));
        return modelAndView;
    }

    @RequestMapping(value = "/show-bicycles", method = RequestMethod.GET)
    public ModelAndView doShowBicycle(@RequestParam Integer itemId) {
        ModelAndView modelAndView = new ModelAndView("modify-bicycles");
        modelAndView.addObject("item", supplyService.getItemAttributes(itemId, Bicycle.class));
        return modelAndView;
    }

    @RequestMapping(value = "/show-item", method = RequestMethod.GET)
    public ModelAndView doShowItem(@RequestParam Integer itemId) {
        ModelAndView modelAndView = new ModelAndView("modify-item");
        modelAndView.addObject("item", supplyService.getItemAttributes(itemId, Item.class));
        return modelAndView;
    }
}
