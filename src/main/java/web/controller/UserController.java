package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.DAO.UserDAO;
import web.model.User;

import javax.servlet.http.HttpServletRequest;

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
        model.addAttribute("users", userDAO.getUserById(id));
        return "user";
    }

    @PostMapping("/new")
    public String createNewUser(@ModelAttribute ("User") User user) {
        userDAO.addNewUser(user);
        return "redirect:/";
    }


}
