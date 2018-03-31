/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * Used to redirecting to view-item.jsp as the start page
 * and also redirection after logging in
 */

package com.shs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {

    @RequestMapping(value = {"/", "/login**"}, method = {RequestMethod.GET})
    public String viewPage() {
        return "view-item";
    }
}