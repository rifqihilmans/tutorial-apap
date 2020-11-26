package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.service.RoleService;
import apap.tutorial.traveloke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUserSubmit(@ModelAttribute UserModel user, Model model){
        if (user.getPassword().length() < 8) {
            model.addAttribute("msg", "Password harus memiliki minimal 8 karakter");
            model.addAttribute("listRole", roleService.findAll());
            return "home";
        }
        else {
            if (user.getPassword().matches(".*[0-9].*") && user.getPassword().matches(".*[a-zA-Z].*")) {
                userService.addUser(user);
                model.addAttribute("msg", "User berhasil ditambahkan!");
                model.addAttribute("listRole", roleService.findAll());
                return "home";
            }
            else if (user.getPassword().matches(".*[0-9].*")){
                model.addAttribute("msg", "Password harus mengandung minimal 1 huruf");
                model.addAttribute("listRole", roleService.findAll());
                return "home";
            }
            else {
                model.addAttribute("msg", "Password harus mengandung minimal 1 angka");
                model.addAttribute("listRole", roleService.findAll());
                return "home";
            }
        }
    }
}
