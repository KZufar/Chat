package ru.ivmiit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivmiit.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}
