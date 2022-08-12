package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.DAO.UserDAO;
import web.model.User;

import javax.validation.Valid;

@Controller
public class UserController {
    UserDAO userDAO = new UserDAO();

    @GetMapping("/")
    public String printAllUsers(ModelMap model) {
        model.addAttribute("users", userDAO.getAllUsers());
        return "usersAll";
    }

    @GetMapping("/{id}")
    public String printUserById(ModelMap model, @PathVariable("id") int id) {
        model.addAttribute("userById", userDAO.getUserById(id));
        return "user";
    }

    @PostMapping("/new")
    public String createNewUser(@ModelAttribute("userNew") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "usersAll";
        userDAO.addNewUser(user);
        return "redirect:/";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("userById") @Valid User user, BindingResult bindingResult,
                             @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "usersAll";
        userDAO.updateUser(user, id);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userDAO.UserDelete(id);
        return "redirect:/";
    }
}
