package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.service.RoleService;
import apap.tutorial.traveloke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class PageController {

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @RequestMapping("/")
    private String home(Model model, Principal principal){
        model.addAttribute("role", userService.getUserByUsername(principal.getName()).getRole().getRole());
        model.addAttribute("listRole", roleService.findAll());
        return "home";
    }

    @RequestMapping("/login")
    private String login(){
        return "login";
    }

}
