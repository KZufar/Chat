package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.User;
import ru.itis.security.role.Role;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByLogin(String login);

    List<User> findAllByRole(Role role);

    Optional<User> findById(Long userId);
}
