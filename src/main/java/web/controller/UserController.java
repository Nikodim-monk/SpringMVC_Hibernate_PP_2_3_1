package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;
import web.DAO.UserDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/users")
    public String printCars(HttpServletRequest request, ModelMap model) {
        UserDAO user = new UserDAO();
        String count = request.getParameter("count");
        if ((count == null) || (Byte.parseByte(count) > 5)) {
            count = "5";
        }
        List<User> users = user.getCars(Byte.parseByte(count));

        model.addAttribute("users",users);
        return "users";
}

}
