package ru.ivmiit.models;

import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "chat_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder()
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String login;

    private String hashPassword;

    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Chat> chats;

    private String email;

    private UUID uuid;

    private String status;
}
