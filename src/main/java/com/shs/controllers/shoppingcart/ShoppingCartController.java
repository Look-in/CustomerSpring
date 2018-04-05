package com.shs.controllers.shoppingcart;

import com.shs.entity.event.ShoppingCart;
import com.shs.entity.items.Item;
import com.shs.service.ChangeCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    @Autowired
    ChangeCart changeCart;

    /**
     * For every request for this controller, item will
     * be added to the cart
     */
    @ModelAttribute(value = "item")
    public List<Item> newRequest(Authentication authentication) {
        if (ShoppingCart.cart.get(authentication.getName()) != null) {
            return ShoppingCart.cart.get(authentication.getName()).getItems();
        }
        return null;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView doGet() {
        ModelAndView modelAndView = new ModelAndView("/view-items");
        modelAndView.addObject("action","shopping");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(@RequestParam int itemId, Authentication authentication) {
        changeCart.updateShoppingCart(authentication.getName(), itemId);
        return "redirect:/view-items";
    }

    @RequestMapping(value = "/put", method = RequestMethod.POST)
    public String doPut(Authentication authentication) {
        String user = authentication.getName();
        if (ShoppingCart.cart.get(user) != null) {
            changeCart.putOrder(user, ShoppingCart.cart.get(user));
        }
        return "redirect:/view-items";
    }
}


