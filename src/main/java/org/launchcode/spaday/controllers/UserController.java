package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String displayWelcome(){
        return "user/index";
    }

    @GetMapping("/add")
    public String displayAddUserForm() {
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
       verify = user.getPassword();
        if(verify.equals(user.getPasswordVerified())) {
            model.addAttribute("username", user);
            model.addAttribute("email", user.getEmail());
            return "redirect";
        } else {
            model.addAttribute("error", "Error: Passwords do not match.");
            return "user/add";
        }
    }
}
