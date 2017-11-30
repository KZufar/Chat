package ru.ivmiit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ivmiit.forms.UserForm;
import ru.ivmiit.models.User;
import ru.ivmiit.repositories.UsersRepository;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.UUID;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void registration(UserForm userForm) {
        User user = User.builder()
                .login(userForm.getLogin())
                .name(userForm.getName())
                .email(userForm.getEmail())
                .hashPassword(encoder.encode(userForm.getPassword()))
                .uuid(UUID.randomUUID())
                .build();

        usersRepository.save(user);
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            message.setContent("hello", "text/html");
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setTo(user.getEmail());
            messageHelper.setSubject("Подвтерждение регистрации в чате");
            messageHelper.setText("http://localhost:8080/confirm/" + user.getUuid(), true);
            messageHelper.setFrom(new InternetAddress("09.622.2group.ivmiit@gmail.com"));
        } catch (MessagingException e) {
            throw new IllegalArgumentException(e);
        }

        javaMailSender.send(message);
    }
}
