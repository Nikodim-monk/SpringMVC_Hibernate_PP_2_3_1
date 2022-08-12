package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.DAO.UserDAO;
import web.model.User;

@Controller
public class UserController {
    UserDAO userDAO=new UserDAO();

    @GetMapping("/")
    public String printAllUsers(ModelMap model) {
        model.addAttribute("users", userDAO.getAllUsers());
        return "usersAll";
    }

    @GetMapping("/{id}")
    public String printUserById(ModelMap model, @PathVariable ("id") int id) {
        model.addAttribute("userById", userDAO.getUserById(id));
        return "user";
    }

    @PostMapping("/new")
    public String createNewUser(@ModelAttribute ("userNew") User user) {
        userDAO.addNewUser(user);
        return "redirect:/";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute ("userById") User user, @PathVariable ("id") long id) {
        userDAO.updateUser(user,id);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable ("id") int id) {
        userDAO.UserDelete(id);
        return "redirect:/";
    }
}
