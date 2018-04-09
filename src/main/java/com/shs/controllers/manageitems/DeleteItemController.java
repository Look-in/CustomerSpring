/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * This controller removes items from datasource using itemId
 */
package com.shs.controllers.manageitems;

import com.shs.service.entity.PushItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        return "redirect:/view-items";
    }
}


