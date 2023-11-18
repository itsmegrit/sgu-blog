package dacn.sgublog.controllers;

import dacn.sgublog.DTOs.RegistrationRequest;
import dacn.sgublog.entities.User;
import dacn.sgublog.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import dacn.sgublog.Exception.UsernameAlreadyExistsException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "registration")
public class RegistrationController {
    @Autowired
    private IUserService userService;
    @GetMapping
    public String register(Model model){
        model.addAttribute("user", new RegistrationRequest());
        return "register";
    }

    @PostMapping
    public String register(@ModelAttribute("user") RegistrationRequest registrationRequest) {
        try {
            User user = userService.registerUser(registrationRequest);
            return "redirect:/";
        } catch (UsernameAlreadyExistsException e) {
            return "redirect:/registration?error=usernameExists";
        }
    }
}
