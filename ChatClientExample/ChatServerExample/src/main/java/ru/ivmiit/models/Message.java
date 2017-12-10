package ru.ivmiit.models;

import lombok.*;

import javax.persistence.*;

/**
 * 10.11.2017
 * Message
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
// @Data - делает конструктор с параметрами, пустой конструктор
// геттеры и сеттеры - lombok

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder()
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;

    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_id")
    private Chat chat;

}
