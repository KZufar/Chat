package ru.itis.security.details;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itis.models.User;
import ru.itis.security.states.State;

import java.util.Collection;
import java.util.Collections;

/**
 * 05.08.2017
 *
 * @author Marsel Sidikov (First Software Engineering Platform)
 * @version 1.0
 */
// UserDetails - интерфейс, который описывает объек безопасности
// реализуем интерфейс по-своему
public class UserDetailsImpl implements UserDetails {
    // объект пользователя, из которого
    // тянутся все данные
    private User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().toString());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return user.getHashPassword();
    }

    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.user.getState().equals(State.CONFIRMED);
    }

    public User getUser() {
        return user;
    }
}
