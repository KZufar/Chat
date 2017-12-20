package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.forms.UserForm;
import ru.itis.models.User;
import ru.itis.services.RegistrationService;
import ru.itis.validators.UserRegistrationFormValidator;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private UserRegistrationFormValidator userRegistrationFormValidator;

    // прикручиваем валидатор ко всем формам, у которых название
    // userForm
    @InitBinder("userForm")
    public void initUserFormValidator(WebDataBinder binder) {
        binder.addValidators(userRegistrationFormValidator);
    }
    @PostMapping(value = "/signUp")
    public String addUser(@Valid @ModelAttribute("userForm") UserForm userForm,
                          BindingResult errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            // кладем специальный атрибут error
            attributes.addFlashAttribute("error", errors.getAllErrors().get(0).getDefaultMessage());
            // перенаправляем пользователя снова на эту же страницу
            // но у же с атрибутом ошибки
            return "redirect:/signUp";
        }

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

    @GetMapping(value = "/signUp")
    public String getSignUpPage() {
        return "sign_up";
    }
}
