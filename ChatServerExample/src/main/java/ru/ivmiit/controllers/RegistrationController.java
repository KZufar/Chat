package ru.ivmiit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.ivmiit.forms.UserForm;
import ru.ivmiit.models.User;
import ru.ivmiit.services.RegistrationService;

import java.util.List;

@Controller
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping(value = "/users")
    public String addUser(@ModelAttribute UserForm userForm) {
        registrationService.registration(userForm);
        return "registration_success";
    }

    @GetMapping(value = "/registration")
    public String getRegistrationPage() {
        return "registration_page";
    }
}
