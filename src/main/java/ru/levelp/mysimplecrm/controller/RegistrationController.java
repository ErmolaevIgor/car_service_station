package ru.levelp.mysimplecrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.levelp.mysimplecrm.model.Users;
import ru.levelp.mysimplecrm.repository.UserRepo;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @RequestMapping(value = "signup")
    public ModelAndView registrationFrom() {
        return new ModelAndView("registrationPage", "users", new Users());
    }

    @RequestMapping(value = "user/register")
    public ModelAndView registerUser(@Valid final Users users, final BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("registrationPage", "users", users);
        }

        userRepo.save(users);

        return new ModelAndView("redirect:/login");
    }
}
