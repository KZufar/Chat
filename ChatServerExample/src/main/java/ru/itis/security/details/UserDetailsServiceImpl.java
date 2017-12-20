package ru.itis.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;

/**
 * 05.08.2017
 *
 * @author Marsel Sidikov (First Software Engineering Platform)
 * @version 1.0
 */
/* UserDetailsService - интерфейс, который позволяет
получить объект авторизации по userName
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = usersRepository.findOneByLogin(login).orElseThrow(()
                -> new IllegalArgumentException("User not found by login <" + login + ">"));
        // создаем объект UserDetails
        // кладем туда пользователя
        return new UserDetailsImpl(user);
    }
}
