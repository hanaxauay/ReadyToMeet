package com.final2.readytomeet.entity;

import com.final2.readytomeet.dto.JoinDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="USER")
public class JoinEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private String USER_ID;

    @Column
    private String USER_PW;

    @Column
    private String USER_PHONE;

    @Column
    private String USER_EMAIL;

    @Column
    private String USER_NAME;

    @Column
    private String USER_NICKNAME;

    @Column
    private int USER_AGE;

    @Column
    private int USER_GENDER;

    @Column
    private String USER_LOCATION;

    public static JoinEntity toJoinEntity(JoinDto joinDto){
        JoinEntity joinEntity = new JoinEntity();
        joinEntity.setUSER_ID(joinDto.getUSER_ID());
        joinEntity.setUSER_PW(joinDto.getUSER_PW());
        joinEntity.setUSER_PHONE(joinDto.getUSER_PHONE());
        joinEntity.setUSER_EMAIL(joinDto.getUSER_EMAIL());
        joinEntity.setUSER_NAME(joinDto.getUSER_NAME());
        joinEntity.setUSER_NICKNAME(joinDto.getUSER_NICKNAME());
        joinEntity.setUSER_AGE(joinDto.getUSER_AGE());
        joinEntity.setUSER_GENDER(joinDto.getUSER_GENDER());
        joinEntity.setUSER_LOCATION(joinDto.getUSER_LOCATION());

        return joinEntity;
    }

}
