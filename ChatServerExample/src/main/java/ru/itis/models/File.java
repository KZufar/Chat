//package ru.ivmiit.models;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.util.UUID;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@EqualsAndHashCode
//@ToString
//@Builder()
//public class File {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String originalFileName;
//    private String storageFileName;
//    private String url;
//    private long size;
//    private String type;
//    private UUID uuid;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "chat_id")
//    private Chat chat;
//}
