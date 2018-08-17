package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.beans.User;
import pl.coderslab.repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String showAddUserrForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addForms/addNewUser";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String receiveAuthorForm(@Valid User user, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "addForms/addNewUser";
        }
        userRepository.save(user);
        return "redirect:/homePage";
    }


}
