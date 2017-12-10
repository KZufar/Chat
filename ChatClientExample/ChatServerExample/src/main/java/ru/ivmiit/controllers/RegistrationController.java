package ru.ivmiit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import ru.ivmiit.forms.UserForm;
import ru.ivmiit.models.User;
import ru.ivmiit.services.RegistrationService;

import java.util.List;
import java.util.Scanner;

@Controller
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping(value = "/users")
    public String addUser(@ModelAttribute UserForm userForm) {
        User user = User.builder()
                .phone(userForm.getPhone()).build();
        registrationService.registration(userForm);
        String login = "kayumov.zufar@gmail.com";
        String MD5 = "8e67d01dfd851d4f0ef21da9348db4df";
        String to = user.getPhone();
        String from = "biznes";
        String type = "7";
        String request = "https://gate.smsaero.ru/send/" + "?user="
                + login + "&password="
                +  MD5+ "&to="
                +  to
                + "&text=" + "Регистрация на сайте прошла успешно"
                + "&from="
                + from + "&type="
                + type;
        System.out.println(request);
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> responseEntity = template.getForEntity(request,String.class);
        System.out.println(responseEntity.getBody());
        return "registration_success";
    }

    @GetMapping(value = "/registration")
    public String getRegistrationPage() {
        return "registration_page";
    }
}
