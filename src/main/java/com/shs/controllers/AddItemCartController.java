package com.shs.controllers;

import com.shs.entity.Item;
import com.shs.entity.Order;
import com.shs.entity.event.ShoppingCart;
import com.shs.service.PushItem;
import com.shs.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/addItemCart")
public class AddItemCartController {

    @Autowired
    private SupplyService supplyService;

    /**
     * For every request for this controller, item will
     * be added to the cart
     */
    @RequestMapping(method = RequestMethod.POST)
    public String doPost(@RequestParam int itemId,
                         Authentication authentication) {
        String user = authentication.getName();
     if (ShoppingCart.cart.get(user) == null) {
         ShoppingCart.cart.put(user, new Order(user, supplyService.getItemAttributes(itemId, Item.class)));
     } else {
         ShoppingCart.cart.get(user).addItem(supplyService.getItemAttributes(itemId, Item.class));
     }
        System.out.println(ShoppingCart.cart.get(user).toString());
        return "redirect:/view-items";
    }
}


