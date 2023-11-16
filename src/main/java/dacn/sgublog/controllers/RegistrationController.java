package dacn.sgublog.controllers;

import dacn.sgublog.DTOs.RegistrationRequest;
import dacn.sgublog.entities.User;
import dacn.sgublog.events.RegistrationCompleteEvent;
import dacn.sgublog.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "registration")
public class RegistrationController {
    @Autowired
    private IUserService userService;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    @GetMapping
    public String register(Model model){
        model.addAttribute("user", new RegistrationRequest());
        return "register";
    }

    @PostMapping
    public String register(@ModelAttribute("user") RegistrationRequest registrationRequest){
        User user = userService.registerUser(registrationRequest);
        applicationEventPublisher.publishEvent(new RegistrationCompleteEvent(user, ""));
        return "redirect:/?success";
    }
}
