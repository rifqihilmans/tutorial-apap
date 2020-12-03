package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.service.RoleService;
import apap.tutorial.traveloke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
            else if (!user.getPassword().matches(".*[0-9].*")){
                model.addAttribute("msg", "Password harus mengandung minimal 1 angka");
                model.addAttribute("listRole", roleService.findAll());
                return "home";
            }
            else {
                model.addAttribute("msg", "Password harus mengandung minimal 1 huruf");
                model.addAttribute("listRole", roleService.findAll());
                return "home";
            }
        }
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.GET)
    private String changePasswordForm(){
        return "update-password";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    private String changePasswordSubmit(@RequestParam String oldPassword,
                                        @RequestParam String newPassword,
                                        @RequestParam String confirmPassword,
                                        @RequestParam String username, Model model) {

        UserModel user = userService.getUserByUsername(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (encoder.matches(oldPassword, user.getPassword()) && newPassword.equals(confirmPassword) && newPassword.length() >= 8 && newPassword.matches(".*[0-9].*") && newPassword.matches(".*[a-zA-Z].*")) {
            user.setPassword(newPassword);
            userService.addUser(user);
            model.addAttribute("msg", "Password berhasil diubah!");
            return "update-password";
        } else if (!encoder.matches(oldPassword, user.getPassword())) {
            model.addAttribute("msg", "Password lama tidak sesuai");
            return "update-password";
        }else if(newPassword.length() < 8){
            model.addAttribute("msg", "Password harus memiliki minimal 8 karakter");
            return "update-password";
        }else if (!newPassword.matches(".*[0-9].*")){
            model.addAttribute("msg", "Password harus mengandung minimal 1 angka");
            return "update-password";
        } else if(!newPassword.matches(".*[a-zA-Z].*")) {
            model.addAttribute("msg", "Password harus mengandung minimal 1 huruf");
            return "update-password";
        }else {
            model.addAttribute("msg", "Password baru tidak sesuai");
            return "update-password";
        }
    }
}
