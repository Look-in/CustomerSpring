/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * This controller operates the shopping cart and
 * displays the items in the user shopping cart
 */
package com.shs.controllers.shoppingcart;

import com.shs.service.shoppingcart.ShoppingCart;
import com.shs.entity.items.Item;
import com.shs.service.shoppingcart.ChangeCart;
import com.shs.service.shoppingcart.GetCart;
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

    @Autowired
    GetCart shoppingCart;

    /**
     * For every request for this controller, items will
     * be added to the view
     */
    @ModelAttribute(value = "item")
    public List<Item> newRequest(Authentication authentication) {
        if (ShoppingCart.shoppingCart.get(authentication.getName()) != null) {
            return ShoppingCart.shoppingCart.get(authentication.getName()).getItems();
        }
        return null;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView doGet() {
        ModelAndView modelAndView = new ModelAndView("/view-items");
        modelAndView.addObject("action","shopping");
        return modelAndView;
    }

    @RequestMapping(value = "/show-orders", method = RequestMethod.GET)
    public ModelAndView doGetCart(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView("/view-items");
        if (!shoppingCart.readUserOrders(authentication.getName()).isEmpty()) {
            //for debugging display only the first order from the list
            modelAndView.addObject("item", shoppingCart.readUserOrders(authentication.getName()).get(0).getItems());
        }
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(@RequestParam int itemId, Authentication authentication) {
        changeCart.addShoppingCartNewItem(authentication.getName(), itemId);
        return "redirect:/view-items";
    }

    @RequestMapping(value = "/put", method = RequestMethod.POST)
    public String doPut(Authentication authentication) {
        String user = authentication.getName();
        if (ShoppingCart.shoppingCart.get(user) != null) {
            changeCart.putOrder(user, ShoppingCart.shoppingCart.get(user));
        }
        return "redirect:/view-items";
    }
}


