package com.example.ss2.controller;

import com.example.ss2.models.User;
import com.example.ss2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String listOfUsers(Model modelMap) {
        modelMap.addAttribute("listOfUsers", userService.getListOfUsers());
        return "users";
    }

    @GetMapping("/user-create")
    public String createUserForm(@ModelAttribute("user") User user,
                                 Model model) {
//        Set<Role> listRoles = roleService.getAllRoles();
//        model.addAttribute("listRoles", listRoles);
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }


    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        //Set<Role> listRoles = roleService.getAllRoles();
        model.addAttribute("user", user);
        //model.addAttribute("listRoles", listRoles);
        return "/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.update(user);
        return "redirect:/admin";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById( id);
        return "redirect:/admin";
    }
}
