//package com.final2.readytomeet.model;
//
//
//import com.sun.istack.NotNull;
//import lombok.*;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Data
//@Builder
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor(force = true)
//public class Image {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @JoinColumn(name= "user_id")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private User user;
//
//
//    private String post_image_url;
//
//    private LocalDateTime create_date;
//
//    @PrePersist
//    public void createDate() {
//        create_date = LocalDateTime.now();
//    }
//}
